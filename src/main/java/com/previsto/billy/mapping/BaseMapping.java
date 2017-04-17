package com.previsto.billy.mapping;

import com.previsto.billy.model.Contact;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public abstract class BaseMapping<T> {

    protected ResponseMeta meta;

    public ResponseMeta getMeta() {
        return meta;
    }
    
    public void setMeta(ResponseMeta meta) {
        this.meta = meta;
    }

    protected void resolveExtraData(T entity) {
        
    }
    
    public static <T> Page<T> resolvePage(ResponseMeta meta, List<? extends T> entities) {
        Paging paging = meta.getPaging();
        Pageable pageable = null;
        int total = -1;
        if(paging != null) {
            pageable = new PageRequest(paging.page - 1, paging.pageSize);
            total = paging.total;
        }
        
        return new PageImpl(entities, pageable, total);
    }
}
