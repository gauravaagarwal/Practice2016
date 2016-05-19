package com.trade.queue;

import java.math.BigDecimal;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.trade.type.Price;

/**
 * This queue uses thread safe collection
 *
 */
public class ConcurrentProductPriceQueue implements FixedSizeQueue {
    private int sizeLimit;

    public ConcurrentProductPriceQueue(int windowLimit) {
        this.sizeLimit = windowLimit;
    }
    /**
     * default limit is set to 4 for use of upward trend algorithm
     */
    //TODO: remove this consturctor and only allow one constructor
    public ConcurrentProductPriceQueue() {
        this.sizeLimit = 4;
    }

    private Queue<BigDecimal> priceList = new ConcurrentLinkedQueue<BigDecimal>() {
        @Override
        public boolean add(BigDecimal o) {
            if (isFull()) {
                super.remove();
            }
            return super.add(o);
        }
    };

    public void addPrice(Price price) {
        priceList.add(price.getPrice());
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
