package com.trade.exception;

public class TradeTypeException extends RuntimeException {

    public TradeTypeException(String string) {
        super(string);
    }
    public TradeTypeException(Throwable e, String string) {
        super(string, e);
    }

}
