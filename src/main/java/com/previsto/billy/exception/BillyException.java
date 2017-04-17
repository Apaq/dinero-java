package com.previsto.billy.exception;

public abstract class BillyException extends RuntimeException {

    private String errorCode;
    private ExceptionMeta meta;
    
    public BillyException(String message, String errorCode, ExceptionMeta meta) {
        super(message, null);
        this.errorCode = errorCode;
        this.meta = meta;
    }

    public BillyException(String message, String errorCode, Throwable e) {
        super(message, e);
        this.errorCode = errorCode;
    }

    public BillyException(String message) {
        super(message, null);
    }

    public BillyException(String message, Throwable e) {
        super(message, e);
    }

    private static final long serialVersionUID = 1L;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ExceptionMeta getMeta() {
        return meta;
    }

    public void setMeta(ExceptionMeta meta) {
        this.meta = meta;
    }

}
