package com.previsto.billy.mapping;

import com.previsto.billy.model.Invoice;

public class SingularInvoiceMapping extends InvoiceMapping implements SingularMapping<Invoice> {
    private Invoice invoice;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public Invoice getEntity() {
        return invoice;
    }

}
