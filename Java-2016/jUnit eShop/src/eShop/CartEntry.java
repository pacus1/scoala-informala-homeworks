package eShop;

public class CartEntry {
	private Book book;
	private int qty;
	
	public CartEntry(Book book, int qty) {
		this.book = book;
		this.qty = qty;
	}
	
	public CartEntry() {
		this.book = null;
		this.qty = 0;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
