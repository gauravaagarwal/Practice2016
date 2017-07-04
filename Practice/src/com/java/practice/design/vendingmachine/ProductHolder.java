package com.java.practice.design.vendingmachine;

public enum ProductHolder {
	
	A1(70),A2(80),A3(90);
	
	private int price;
	 private ProductHolder(int price){
		this.price=price;
	}
	public String getId(){
		return this.name();
	}
	public int getPrice(){
		return price;
	};
	public void setPrice(int price){
		 this.price=price;
	};
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: "+this.name() + " price: "+price;
	}

}