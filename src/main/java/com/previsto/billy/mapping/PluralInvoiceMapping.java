package com.previsto.billy.mapping;

import com.previsto.billy.model.Invoice;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PluralInvoiceMapping extends InvoiceMapping implements PluralMapping<Invoice>{
    private List<Invoice> invoices;

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public Page<Invoice> getPage() {
        invoices.forEach((i) -> resolveExtraData(i));
        return BaseMapping.resolvePage(getMeta(), invoices);
    }
    
}