package com.java.practice.design.vendingmachine;

/**
 * @author gauravaagarwal
 *
 */
public class AbstractVendingMachine implements VendingMachine {
	Inventory<Coin> coinStorage = new Inventory<Coin>();
	Inventory<ProductHolder> productStorage = new Inventory<ProductHolder>();
	private static VendingMachine vm = null;
	int receivedMoney = 0;

	public void initialize() {
		addNewProduct(ProductHolder.A1, 10);
		addNewProduct(ProductHolder.A2, 10);
		addNewProduct(ProductHolder.A3, 10);
		addNewProduct(ProductHolder.A1, 10);
	}

	public void addNewProduct(ProductHolder product, int quantity) {
		productStorage.addItem(product, quantity);
	}

	public void receiveCoin(Coin coin) {
		receivedMoney += coin.getPrice();
	}

	public void deliverProduct(ProductHolder selectedProduct) {
		int quantity = productStorage.getItemCount(selectedProduct);
		if (quantity <= 0) {
			System.out.println("Insufficient product quantity, pleaese select other product");
		}
		// System.out.println("selected product: "+selectedProduct.getId());
		// System.out.println("requested product: "+id);

		if (selectedProduct.getPrice() <= receivedMoney) {
			productStorage.removeItem(selectedProduct);
			dispenseProduct(selectedProduct);
			returnBalance(receivedMoney - selectedProduct.getPrice());
			receivedMoney = 0;
		} else {
			System.out.println("insuffiecient money: " + receivedMoney + " Please add more "
					+ (selectedProduct.getPrice() - receivedMoney) + " cents");
		}
	}

	public void returnBalance(int balanceAmount) {
		System.out.println("Balance cents:" + balanceAmount);
	}

	public static void main(String[] args) {
		VendingMachine vm = null;
		System.out.println(ProductHolder.valueOf("A1"));
		System.out.println(0 / 1);
	}

	@Override
	public void reset() {
		productStorage.reset();
		coinStorage.reset();
	}

	@Override
	public void dispenseProduct(ProductHolder productId) {
		System.out.println("Product dispensed: " + productId);
		// TODO Auto-generated method stub
		
	}
}
