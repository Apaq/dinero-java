package com.previsto.dinero.mapping;

import org.springframework.data.domain.Page;

public interface PluralMapping<T> {
    Page<T> getPage();
}
