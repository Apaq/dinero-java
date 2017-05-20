package com.previsto.dinero.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by michael on 20/05/2017.
 */
public class ContactCreate {

    @JsonProperty("ContactGuid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
