package com.lnbei.exception;

public class NoEditExecption extends RuntimeException{
    private static final long serialVersionUID = 1L;

    protected final String message;

    public NoEditExecption(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
