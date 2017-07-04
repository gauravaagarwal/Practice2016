package com.java.practice.command;

public class OrderExecutor {
	Order order;
	
	public OrderExecutor(Order order) {
		super();
		this.order = order;
	}

	public void acceptOrder(){
		order.execute();
	}
}
