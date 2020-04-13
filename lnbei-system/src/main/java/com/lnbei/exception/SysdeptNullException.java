package com.lnbei.exception;

public class SysdeptNullException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected final String message;

    public SysdeptNullException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
