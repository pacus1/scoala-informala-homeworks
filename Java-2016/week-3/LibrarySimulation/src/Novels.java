
public class Novels extends Books{
	private String type;
	boolean added;

	public Novels(String bookName, int noOfPages, String type) {
		this.bookName = bookName;
		this.noOfPages = noOfPages;
		this.type = type;			
	}
	public String getNovelName(){
		return this.getBookName();
	}
	
	public String getNovelType(){
		return this.type;
	}
	
	public void addNovel(String bookName, int noOfPages, String type){
		String bookRow;
		bookRow = bookName + "," + noOfPages + "," + type;
		LibraryCatalog.addBookToLibrary(bookRow);//add a return type in case the write to catalog is ok
	}
	
	public void deleteNovel(String bookName){
		LibraryCatalog.deleteBookFromLibrary(bookName);//add a return type in case the write to catalog is ok
		//return true;
	}
	
	
}
