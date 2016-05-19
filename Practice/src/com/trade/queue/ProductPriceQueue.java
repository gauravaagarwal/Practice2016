package com.trade.queue;

import java.math.BigDecimal;
import java.util.LinkedList;

import com.trade.type.Price;

/**
 * This queue is not thread safe
 *
 */
public class ProductPriceQueue implements FixedSizeQueue {
    /**
     * max number of prices this queue can hold
     */
    private int sizeLimit;

    public ProductPriceQueue(int windowLimit) {
        this.sizeLimit = windowLimit;
    }
    /**
     * default limit is set to 4 for use of upward trend algorithm
     */
    //TODO: remove this consturctor and only allow one constructor
    public ProductPriceQueue() {
        this.sizeLimit = 4;
    }

    private LinkedList<BigDecimal> priceList = new LinkedList<BigDecimal>() {
        @Override
        public void addFirst(BigDecimal o) {
            if (isFull()) {
                super.removeLast();
            }
            super.addFirst(o);
        }
    };

    public void addPrice(Price price) {
        priceList.addFirst(price.getPrice());
    }

    private boolean isFull() {
        return priceList.size() == sizeLimit;
    }

    public BigDecimal getAveragePriceInWindow() {
        if (!isFull())
            return null;
        BigDecimal total = new BigDecimal(0);
        for (BigDecimal price : priceList) {
            total = total.add(price);
        }
        return total.divide(new BigDecimal(priceList.size()));
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return priceList.toString();
    }
}

