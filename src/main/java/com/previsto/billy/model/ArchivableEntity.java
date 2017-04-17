package com.previsto.billy.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArchivableEntity extends Entity {
    @JsonProperty("isArchived")
    private boolean archived;

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    
}
