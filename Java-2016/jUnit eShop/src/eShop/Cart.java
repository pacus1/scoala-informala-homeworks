package eShop;


import java.util.ArrayList;
import java.util.List;


public class Cart {
	private List<CartEntry> cartEntry;
	private float totalPrice;
	//private Stock stock;
	
	public Cart(List<CartEntry> cartEntry) {
		this.cartEntry = cartEntry;
		this.totalPrice = 0;
	}

	public Cart() {
		this.cartEntry = new ArrayList <CartEntry>();
		this.totalPrice = 0;
	}

	public List<CartEntry> getCartEntry() {
		return cartEntry;
	}

	public void setCartEntry(List<CartEntry> cartEntry) {
		this.cartEntry = cartEntry;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	public void addToCart(CartEntry custCart){
		int testStock;
		//testStock = shop.decreaseStock(((CartEntry) cartEntry).getBook(), ((CartEntry) cartEntry).getQty());
		testStock=3;
		
		if (testStock >= 0 ){
			cartEntry.add(custCart);
			totalPrice = totalPrice + custCart.getBook().getPrice() * custCart.getQty();
		}
		
	}
}
