package com.previsto.dinero.mapping;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.previsto.dinero.model.InvoiceProductLine;

public class InvoiceProductLineFilter extends SimpleBeanPropertyFilter {
    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
            throws Exception {
        if(pojo instanceof InvoiceProductLine) {
            InvoiceProductLine line = (InvoiceProductLine) pojo;
            if(line.getProductId() != null) {
                line.setDescription(null);
            }
        }
        writer.serializeAsField(pojo, jgen, provider);
    }

}
