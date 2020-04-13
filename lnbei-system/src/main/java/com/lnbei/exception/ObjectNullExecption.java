package com.lnbei.exception;

public class ObjectNullExecption extends RuntimeException{
    private static final long serialVersionUID = 1L;

    protected final String message;

    public ObjectNullExecption(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
