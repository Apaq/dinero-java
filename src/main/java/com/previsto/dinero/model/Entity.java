package com.previsto.dinero.model;

import org.springframework.data.domain.Persistable;

public interface Entity extends Persistable<String> {

    void setId(String id);
}
