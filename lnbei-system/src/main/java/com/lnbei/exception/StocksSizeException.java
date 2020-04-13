package com.lnbei.exception;

public class StocksSizeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected final String message;

    public StocksSizeException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
