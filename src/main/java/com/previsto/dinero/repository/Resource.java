package com.previsto.dinero.repository;

import com.previsto.dinero.exception.RequestException;
import com.previsto.dinero.exception.ResourceNotFoundException;
import com.previsto.dinero.exception.UnknownException;
import com.previsto.dinero.mapping.PersistMapping;
import com.previsto.dinero.mapping.PluralMapping;
import com.previsto.dinero.mapping.SingularMapping;
import com.previsto.dinero.model.Entity;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Persistable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class Resource<T extends Persistable<String>> {

    private static final Logger LOG = LoggerFactory.getLogger(Resource.class);
    protected final RestTemplate restTemplate;
    protected final String serviceUrl;
    protected Class<? extends SingularMapping<T>> singularClass;
    protected Class<? extends PersistMapping<T>> persistClass;
    protected Class<? extends PluralMapping<T>> pluralClass;
    protected String resourceName;
    protected Map<String, String> sideloadParams;

    public Resource(Class<? extends SingularMapping<T>> singularClass, Class<? extends PluralMapping<T>> pluralClass, 
            Class<? extends PersistMapping<T>> persistClass, String resourceName, RestTemplate restTemplate, String serviceUrl, 
            Map<String, String> sideloadParams) {
        this.singularClass = singularClass;
        this.pluralClass = pluralClass;
        this.persistClass = persistClass;
        this.resourceName = resourceName;
        this.restTemplate = restTemplate;
        this.serviceUrl = serviceUrl;
        this.sideloadParams = sideloadParams == null ? Collections.EMPTY_MAP : sideloadParams;
    }

    public List<T> findAll() {
        return findAll(null).getContent();
    }

    public Page<T> findAll(PageRequest pageRequest) {
        URI url = buildUri();
        ParameterizedTypeReference<List<T>> responseType = new ParameterizedTypeReference<List<T>>() {
            @Override
            public Type getType() {
                return pluralClass;
            }
        };

        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(url);
        if (pageRequest != null) {
            builder.queryParam("page", pageRequest.getPageNumber() + 1);
            builder.queryParam("pageSize", pageRequest.getPageSize());
        }
        
        for (Map.Entry<String, String> entry : sideloadParams.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }

        url = builder.build().encode().toUri();
        ResponseEntity resp = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
        PluralMapping<T> result = (PluralMapping<T>) resp.getBody();
        
        return result.getPage();
    }

    public T get(String id) {
        URI url = buildUri(id);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(url);
        
        for (Map.Entry<String, String> entry : sideloadParams.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }

        url = builder.build().encode().toUri();
        try {
            SingularMapping<T> result = (SingularMapping<T>) restTemplate.getForObject(url, singularClass);
            return result.getEntity();
        } catch(ResourceNotFoundException ex) {
            LOG.debug("Unable to find resource [id={}]", id);
            return null;
        }
    }

    public void delete(T entity) {
        Entity e = null;
        if(entity instanceof Entity) {
            e = (Entity) entity;
        }
        if (e == null || e.getId() == null) {
            throw new RequestException("Entity cannot be deleted, because it has no id.");
        }
        delete(e.getId());
    }

    public void delete(String id) {
        restTemplate.delete(buildUri(id));
    }

    public T save(T entity) {
        if(!(entity instanceof Entity)) {
            throw new RequestException("Entity cannot be persisted.");
        }
        
        PersistMapping<T> mapping = null;
        try {
            mapping = persistClass.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new UnknownException("Unable to create instance of singularClass");
        }
        
        mapping.setEntity(entity);
        URI uri = buildUri(entity.getId());
        T persistedEntity;
        
        if(entity.getId() == null) {
            ResponseEntity<? extends PluralMapping<T>> response = restTemplate.postForEntity(uri, mapping, pluralClass);
            persistedEntity = response.getBody().getPage().getContent().get(0);
        } else {
            restTemplate.put(uri, mapping);
            persistedEntity = entity;
        }
        
        return persistedEntity;
    }

    protected URI buildUri() {
        return this.buildUri(null);
    }

    protected URI buildUri(String id) {
        return buildUri(id, null);
    }
    
    protected URI buildUri(String id, String suffix) {
        try {
            String url = serviceUrl + "/" + resourceName;
            if(id != null) {
                url += "/" + id;
            }
            
            if(suffix != null) {
                url += suffix;
            }
            
            return new URI(url);
        } catch (URISyntaxException ex) {
            LOG.error("URI invalid.", ex);
            throw new IllegalArgumentException("Url is not valid.", ex);
        }
    }

    
}
