package eShopTestPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import eShop.Address;
import eShop.Book;
import eShop.Cart;
import eShop.CartEntry;
import eShop.CurrencyType;
import eShop.Customer;
import eShop.Stock;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import java.util.ArrayList;
import java.util.List;

public class EShopTest{		
	Book book, book1;
	Address address;
	Customer customer;
	Cart cart;
	CartEntry cartEntry;
	
	//@BeforeClass - why is not possible to use it here
	// Answer: because of this: http://junit.sourceforge.net/javadoc/org/junit/BeforeClass.html
	Stock shop = new Stock();
	
	@Before
	public void init(){
		
		
		cartEntry = new CartEntry();
		cart = new Cart();
		address = new Address("Eroilor",10,"Cluj-Napoca");
		
		customer = new Customer("Sergiu", address, "s@yahoo.com", cart);
		book = new Book("povesti","copii","Ispirescu",200.0f,123456,10.2f,CurrencyType.RON);
		shop.addNewBooksToStock(book, 5);
		
		cartEntry = new CartEntry(book,2);
		shop.decreaseStock(book, cartEntry.getQty());//ask Alex where this check should be placed better 
					//here in the main procedure or in "AddToCart" method from Cart class (where I wasn't able to add it).
		//Answer: in addToCart, the addToCart method should hide all kind of operations like stock management or any shop related concerns
		cart.addToCart(cartEntry);		
		
		book1 = new Book("abecedar","copii","Ispirescu",100.0f,654321,20f,CurrencyType.RON);
		shop.addNewBooksToStock(book1, 2);
		
		cartEntry = new CartEntry(book1,1);	
		shop.decreaseStock(book1, cartEntry.getQty());
		cart.addToCart(cartEntry);
		
		System.out.println("Before");
	}
		
	@Test
	public void testShop() {
		assertNotNull(shop);
		//testing the stock value for a book 
		int stockTest1 = shop.getStockQty(0);		
		System.out.println("no of books with the title " + shop.getStock(0).getTitle() + " are: " + shop.getStockQty(0));
		assertEquals(3, stockTest1);
		
		int stockTest2 = shop.getStockQty(1);		
		System.out.println("no of books with the title " + shop.getStock(1).getTitle() + " are: " + shop.getStockQty(1));
		assertEquals(1, stockTest2);
	}

	@Test
	public void testBook() {
		assertNotNull(book);
		assertEquals("povesti", book.getTitle());
	}

	@Test
	public void testAddress() {
		assertNotNull(address);
		assertEquals("Cluj-Napoca", address.getCityName());
	}
	
	@Test
	public void testCart() {
		assertNotNull(cart);
		assertEquals(40.4, cart.getTotalPrice(),0.1);
		assertEquals(3, shop.getStockQty(0),0.1);
	}
	
	@Test
	public void testCustomer() {
		assertNotNull(book);
		assertEquals("Cluj-Napoca", customer.getAddress().getCityName());
	}
	
	@Test
	public void testCartEntry() {
		assertNotNull(book);
	}
	
	@Test
	//add to cart more books than what is currently in stock
	//ask Alex if for this test is ok to have the initialization code here not only the assertion
	// Answer: it is ok, however you should not invoke explicitly decrease stock, that should happen automatically when adding to cart
	public void testShop2() {
		int shopDecreaseReturn;
		cartEntry = new CartEntry(book,5);
		shopDecreaseReturn = shop.decreaseStock(book, cartEntry.getQty());
			//cart.addToCart(cartEntry);
		assertEquals(-1, shopDecreaseReturn);
	}
	
	@After
	public void destroy() {
		shop = null;
		System.out.println("After");
	}
	
}
