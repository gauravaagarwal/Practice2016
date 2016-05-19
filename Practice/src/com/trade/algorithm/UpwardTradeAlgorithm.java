package com.trade.algorithm;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.trade.exception.TradeTypeException;
import com.trade.queue.FixedSizeQueue;
import com.trade.type.Price;
import com.trade.type.Trade;

public class UpwardTradeAlgorithm<T extends FixedSizeQueue> implements
        TradeAlgorithm<T> {
    /**
     * Map to hold product name and it's prices
     */
    final Map<String, T> productPriceMap = new HashMap<String, T>();

    /**
     * class used for creating queue to hold prices
     */
    final Class<T> clazz;

    public UpwardTradeAlgorithm(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    public Trade buildTrades(final Price currentProductPrice)
            throws TradeTypeException {
        if (productPriceMap.containsKey(currentProductPrice.getProductName())) {
            T productPriceHolder = productPriceMap.get(currentProductPrice
                    .getProductName());
            if (productPriceHolder==null){
                throw new TradeTypeException("UpwardTradeAlgorithm not initialized");
            }
            synchronized (productPriceHolder) {
                productPriceHolder.addPrice(currentProductPrice);
                BigDecimal averagePrice = productPriceHolder
                        .getAveragePriceInWindow();
                if (null != averagePrice
                        && currentProductPrice.getPrice().compareTo(averagePrice) > 0) {
                    return new Trade(currentProductPrice);
                }
            }
        } else {
            // this product can not be traded.
            System.out.println("This product " + currentProductPrice.getProductName()
                    + " can not be traded");
        }
        // productPriceSet.
        return null;
    }

    private T getNewInstance() throws TradeTypeException {
        T instance = null;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new TradeTypeException(e,
                    "Unable to instantiate new object for class" + clazz);
        } catch (IllegalAccessException e) {
            throw new TradeTypeException(e,
                    "Unable to instantiate new object for class" + clazz);
        }
        return instance;
    }

    public void initialize(String[] productNames) {
        for (String key : productNames) {
            productPriceMap.put(key, getNewInstance());
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        return sb.toString();
    }

}
