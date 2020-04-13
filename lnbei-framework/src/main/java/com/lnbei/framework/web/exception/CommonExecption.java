package com.lnbei.framework.web.exception;

public class CommonExecption extends RuntimeException{
    private static final long serialVersionUID = 1L;

    protected final String message;

    public CommonExecption(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
