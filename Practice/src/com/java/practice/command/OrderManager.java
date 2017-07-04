package com.java.practice.command;

import java.math.BigDecimal;

public class OrderManager {
	public static void main(String[] args) {
		Stock VIP = new StockImpl(BigDecimal.TEN,"VIP");
		Order order = new BuyOrder(VIP, 5);
		OrderExecutor executor = new OrderExecutor(order);
		executor.acceptOrder();
	}
}
