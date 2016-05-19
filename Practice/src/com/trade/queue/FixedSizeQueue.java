package com.trade.queue;

import java.math.BigDecimal;

import com.trade.type.Price;

public interface FixedSizeQueue {
    // TODO: change to generics if need to use this queue for other data
    // types
    public BigDecimal getAveragePriceInWindow();

    // TODO: change to generics if need to use this queue for other data
    // types
    public void addPrice(Price price);
}
