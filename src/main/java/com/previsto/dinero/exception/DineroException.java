package com.previsto.dinero.exception;

import java.util.List;
import java.util.Map;

public abstract class DineroException extends RuntimeException {

    private int code;
    private List<LanguageSpecificMessage> languageSpecificMessages;

    public DineroException(String message, int code,
                           List<LanguageSpecificMessage> languageSpecificMessages) {
        super(message, null);
        this.code = code;
        this.languageSpecificMessages = languageSpecificMessages;
    }

    public DineroException(String message, int code, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public DineroException(String message) {
        super(message, null);
    }
    public DineroException(String message, int code) {
        super(message, null);
        this.code = code;
    }

    public DineroException(String message, Throwable e) {
        super(message, e);
    }

    private static final long serialVersionUID = 1L;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<LanguageSpecificMessage> getLanguageSpecificMessages() {
        return languageSpecificMessages;
    }

    public void setLanguageSpecificMessages(List<LanguageSpecificMessage> languageSpecificMessages) {
        this.languageSpecificMessages = languageSpecificMessages;
    }
}
