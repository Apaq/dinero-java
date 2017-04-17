package com.previsto.billy.mapping;

import com.previsto.billy.model.Invoice;
import com.previsto.billy.model.InvoiceLine;
import java.util.List;

public abstract class InvoiceMapping extends BaseMapping<Invoice> {

    private List<InvoiceLine> lines;

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }

    protected void resolveExtraData(Invoice invoice) {
        invoice.setLines(getLines());
    }
    
    
}
