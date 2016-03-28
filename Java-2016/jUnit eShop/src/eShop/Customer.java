package eShop;

public class Customer {
	private String name;
	private Address address;
	private String email;
	private Cart cart;
	
	public Customer(String name, Address address, String email, Cart cart) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.cart = cart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	
}
