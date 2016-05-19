package com.trade.type;


public class Trade {
    private Price productPrice;

    public Trade(Price price) {
        this.productPrice = price;
        direction = Direction.BUY;
    }

    private static final int quantity = 1000;

    private Direction direction;

    public Price getProductPrice() {
        return productPrice;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return productPrice.toString() + ", " + direction + ", " + quantity;
    }
}
