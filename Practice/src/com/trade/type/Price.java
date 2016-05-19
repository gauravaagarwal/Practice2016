package com.trade.type;

import java.math.BigDecimal;

public class Price {
    private String productName;

    private BigDecimal price;

    public Price(String productName, BigDecimal price) {
        super();
        this.productName = productName;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return productName.toString() + ", " + price.toString();
    }

}
