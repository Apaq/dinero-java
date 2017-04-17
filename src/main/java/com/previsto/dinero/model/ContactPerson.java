package com.previsto.dinero.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactPerson extends Entity {

    @JsonProperty("isPrimary")
    private boolean primary;
    private String name;
    private String email;

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
