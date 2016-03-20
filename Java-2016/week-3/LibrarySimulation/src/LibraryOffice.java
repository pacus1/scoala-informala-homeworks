import java.util.Scanner;

public class LibraryOffice {

	public static void main(String[] args) {
		String bookName;//temporary value used to read from console
		int noOfPages;//temporary value used to read from console
		String type;//temporary value used to read from console
		int pageQuality;//temporary value used to read from console
		int selection;//function selection from console
		String temp;
		boolean testWrite;
		
		System.out.println("Welcome to school library");
		System.out.println("enter what do you want to do");
				
		do{		
			System.out.println("1 - list the books from library");
			System.out.println("2 - add new book to library");
			System.out.println("3 - delete a book from library");
			System.out.println("4 - exit the application");
			selection = new Scanner (System.in).nextInt();
			
			switch (selection) {
				case 1: System.out.println("you have selected" + " - list the books from library");
					LibraryCatalog.listCatalog();				
					break;
				case 2: System.out.println("you have selected" + " - add new book to library");		
					System.out.println("1 - Add Novels");
					System.out.println("2 - Add Albums");	
					
					selection = new Scanner (System.in).nextInt();
					switch (selection){
						case 1: 
							System.out.println("Add a Novel - Name, No of Pages and Type");
							bookName = new Scanner (System.in).nextLine();
							noOfPages = new Scanner (System.in).nextInt();
							type = new Scanner (System.in).next();
							Novels book = new Novels (bookName, noOfPages, type);
							System.out.println("name entered is " + book.getBookName());
							System.out.println("name entered is " + book.getBookPages());
							System.out.println("name entered is " + book.getNovelType());
		
							String bookRow = bookName + "," + noOfPages + "," + type;
							System.out.println("data sent to file " + bookRow);
                            /*
                            TODO - CODE REVIEW
                            
                            Think of a real life book. Can a novel add itself to a library? No.
                            
                            A more realistic scenario would be:
                            LibraryCatalog library = new LibraryCatalog();
                            library.addBook(book);
                            */
							book.addNovel(book.getBookName(), book.getBookPages(), book.getNovelType());
							break;
						case 2:
							System.out.println("Add an Album - Name, No of Pages and Paper Quality");
							bookName = new Scanner (System.in).nextLine();
							noOfPages = new Scanner (System.in).nextInt();
							pageQuality = new Scanner (System.in).nextInt();
							Albums book1 = new Albums (bookName, noOfPages, pageQuality);
							System.out.println("name entered is " + book1.getBookName());
							System.out.println("name entered is " + book1.getBookPages());
							System.out.println("name entered is " + book1.getAlbumPageQuality());
							String bookRow1 = bookName + "," + noOfPages + "," + pageQuality;
							System.out.println("data sent to file " + bookRow1);
							book1.addAlbums(book1.getBookName(), book1.getBookPages(), book1.getAlbumPageQuality());
							break;
					}
					break;	
				case 3: 
					System.out.println("you have selected" + " - delete a book from library");
					System.out.println("enter the name of the book you want to delete");
					bookName = new Scanner (System.in).nextLine();
					LibraryCatalog.deleteBookFromLibrary(bookName);
					break;
				default:
			}
			System.out.println("press enter to go further");
			temp = new Scanner (System.in).nextLine();
		}while (selection != 4);	
		System.out.println("exit the application, have a nice day");
	}
	
}
