package com.java.practice.command;

public interface Order {
	void execute();
}
class BuyOrder implements Order{
	Stock stock;
	int quantity;
	
	public BuyOrder(Stock stock, int quantity) {
		super();
		this.stock = stock;
		this.quantity = quantity;
	}

	public void execute(){
		stock.buy(quantity);
		System.out.println("execute buy order");
	}
}
class SellOrder implements Order{
	Stock stock;
	int quantity;
	public SellOrder(Stock stock, int quantity) {
		super();
		this.stock = stock;
		this.quantity = quantity;
	}
	public void execute(){
		stock.sell(quantity);
		System.out.println("execute sell order");
	}
}
