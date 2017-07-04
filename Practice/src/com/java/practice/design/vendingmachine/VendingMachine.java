package com.java.practice.design.vendingmachine;

/**
 * @author gauravaagarwal
 *
 */
public interface VendingMachine {
	public void initialize() ;
	public void addNewProduct(ProductHolder product, int quantity);
	public void receiveCoin(Coin coin) ;
	public void deliverProduct(ProductHolder id);
	public void returnBalance(int balanceAmount) ;
	public void dispenseProduct(ProductHolder productId) ;
	public void reset();
}





