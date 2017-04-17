package com.previsto.dinero.exception;

public abstract class DineroException extends RuntimeException {

    private String errorCode;
    private ExceptionMeta meta;
    
    public DineroException(String message, String errorCode, ExceptionMeta meta) {
        super(message, null);
        this.errorCode = errorCode;
        this.meta = meta;
    }

    public DineroException(String message, String errorCode, Throwable e) {
        super(message, e);
        this.errorCode = errorCode;
    }

    public DineroException(String message) {
        super(message, null);
    }

    public DineroException(String message, Throwable e) {
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
