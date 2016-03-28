package eShop;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	private List<Book> stock;
	private List <Integer> stockQty;

	public Stock() {
		this.stock = new ArrayList<Book>();
		this.stockQty = new ArrayList <Integer>(1);
	}

	public void addNewBooksToStock(Book book, int stockQty){
		int currStock;
		int bookLocation;

		bookLocation = searchStock(book);

		if (bookLocation == -1){
			stock.add(book);
			this.stockQty.add(stockQty);	
		}else {
			currStock = this.stockQty.get(bookLocation);
			this.stockQty.set(bookLocation, currStock + stockQty);
		}	
	}

	public int decreaseStock(Book book, int noOfBooks){
		int currStock;
		int bookLocation;

		bookLocation = searchStock(book);

		if (bookLocation!=-1){
			currStock = getStockQty(bookLocation);
			if (noOfBooks>currStock){
				System.out.println("we have only " + currStock + " books left");	
				return -1;
			}else {
				setStockQty(bookLocation,currStock - noOfBooks);
			}
		}	
		return stockQty.get(bookLocation);
	}

	public Book getStock(int i) {
		return stock.get(i);
	}

	public void setStock(List<Book> stock) {
		this.stock = stock;
	}

	public Integer getStockQty(int i) {
		return this.stockQty.get(i);
	}

	public void setStockQty(int i, int newStock) {
		this.stockQty.set(i, newStock);
	}

	public int searchStock(Book bookToFind){
		int i=0;
		for (Book book : stock){
			i++;
			if(book.getTitle() == bookToFind.getTitle()){		
				return i-1;//returns book position in the list
			}
		}
		return -1;
	}

}
