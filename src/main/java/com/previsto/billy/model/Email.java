package com.previsto.billy.model;

public class Email {
    private String contactPersonId;
    private String copyToUserId;
    private String emailBody;
    private String emailSubject;

    public String getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(String contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public String getCopyToUserId() {
        return copyToUserId;
    }

    public void setCopyToUserId(String copyToUserId) {
        this.copyToUserId = copyToUserId;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    
}
