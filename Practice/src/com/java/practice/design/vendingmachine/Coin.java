package com.java.practice.design.vendingmachine;

/**
 * @author gauravaagarwal
 *
 */
enum Coin {
	FIVECENT(5), TENCENT(10), TWENTYCENT(20), FIFTYCENT(50), ONEDOLLAR(100);
	private int price;

	Coin(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
};
