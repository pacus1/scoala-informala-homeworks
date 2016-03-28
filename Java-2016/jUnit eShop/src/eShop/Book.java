package eShop;

import java.util.List;

public class Book {
	private String title;
	private String genre;
	private String author;
	private float weight;
	private long isbn;
	private float price;
	private CurrencyType currency;
	
	public Book(String title, String genre, String author, float weight, long iSBN, float price,
			CurrencyType currency) {
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.weight = weight;
		this.isbn = iSBN;
		this.price = price;
		this.currency = currency;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public CurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}
	
	
	
}
