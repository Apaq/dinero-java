package com.previsto.dinero.model;

import java.util.ArrayList;
import java.util.List;

public class SendEmailResponse {
    private List<EmailRecipient> recipients = new ArrayList<>();

    public List<EmailRecipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<EmailRecipient> recipients) {
        this.recipients = recipients;
    }
}
