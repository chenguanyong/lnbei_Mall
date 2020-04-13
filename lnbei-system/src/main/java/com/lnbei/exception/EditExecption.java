package com.lnbei.exception;

public class EditExecption extends RuntimeException{
    private static final long serialVersionUID = 1L;

    protected final String message;

    public EditExecption(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
