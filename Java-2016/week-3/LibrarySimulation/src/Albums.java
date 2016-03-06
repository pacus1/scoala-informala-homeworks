
public class Albums extends Books{
	private int pageQuality;
	
	public Albums(String bookName, int noOfPages,int pageQuality) {
		this.bookName = bookName;
		this.noOfPages = noOfPages;
		this.pageQuality = pageQuality;			
	}
	public String getAlbumName(){
		return this.getBookName();
	}
	
	public int getAlbumPageQuality(){
		return this.pageQuality;
	}

	public void addAlbums(String bookName, int noOfPages, int pageQuality){
		String bookRow;
		bookRow = bookName + "," + noOfPages + "," + pageQuality;
		LibraryCatalog.addBookToLibrary(bookRow);//add a return type in case the write to catalog is ok
	}
	
}
