package com.trade.businessservices;

import java.util.ArrayList;
import java.util.List;

import com.trade.algorithm.TradeAlgorithm;
import com.trade.algorithm.UpwardTradeAlgorithm;
import com.trade.exception.TradeTypeException;
import com.trade.queue.ConcurrentProductPriceQueue;
import com.trade.queue.ProductPriceQueue;
import com.trade.type.Price;
import com.trade.type.Trade;

/**
 * @author gauravaa
 *
 */
public class AutomatedTrader {
    TradeAlgorithm algorithm = null;

    /**
     * @param productNames
     * @param queueType - this is class name for queue to be used
     * initializes algorithm with product names that can be traded
     */
    public void init(String[] productNames,Class queueType) {
        if (queueType==ProductPriceQueue.class) {
            //TODO: avoid same information about queueType being passed twice
        algorithm = new UpwardTradeAlgorithm<ProductPriceQueue>(
                ProductPriceQueue.class);
        } else if (queueType==ConcurrentProductPriceQueue.class) {
            algorithm = new UpwardTradeAlgorithm<ConcurrentProductPriceQueue>(
                    ConcurrentProductPriceQueue.class);
        }
        algorithm.initialize(productNames);
    }
    
    /**
     * @param prices
     * @return successful Trade otherwise null
     */
    public Trade receivePrices(List<Price> prices) {
        //TODO: this function should return list of trades, but requirement say this function to return only Trade
        List<Trade> trades=new ArrayList<Trade>();
        
        if (algorithm==null){
            throw new TradeTypeException("AutomatedTrader not initialized");
        }
        
        for (Price price : prices) {
            Trade trade = algorithm.buildTrades(price);
            if (trade != null) {
                
                return trade;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return algorithm.toString();
    }
}

