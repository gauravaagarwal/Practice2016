package com.java.practice.command;

import java.math.BigDecimal;

public interface Stock {
	
	public void buy(int quantity);
	public void sell(int quantity);
	public BigDecimal getPrice();
	public void setPrice(BigDecimal price);

}

class StockImpl implements Stock {
	BigDecimal price;
	String name;
	
	public StockImpl(BigDecimal price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	@Override
	public void buy(int quantity) {
		System.out.println("Stock: "+ name + " quantity "+quantity +" BOUGHT at: " + price+ " $per stock");
	}

	@Override
	public void sell(int quantity) {
		System.out.println("Stock: "+ name + " quantity "+quantity +" SOLD at: " + price+ " $per stock");
		
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
