
public class Books {
	protected String bookName;
	protected int noOfPages;

	public void addBooks (String bookName, int noOfPages){
		this.bookName = bookName;
		this.noOfPages = noOfPages;
	}
	
	public String getBookName() {
		return this.bookName;
	}
	
	public int getBookPages() {
		return this.noOfPages;
	}
}
