package com.trade.algorithm;

import com.trade.exception.TradeTypeException;
import com.trade.type.Price;
import com.trade.type.Trade;
import com.trade.queue.*;

public interface TradeAlgorithm<T extends FixedSizeQueue> {
    /** 

    * Builds a trade to be executed based on the supplied prices. 

    * @param price data 

    * @return trade to execute 

    */ 
    public Trade buildTrades(Price price) throws TradeTypeException;

    public void initialize(String[] productNames);
}
