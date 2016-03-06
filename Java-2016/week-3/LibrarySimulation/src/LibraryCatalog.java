import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LibraryCatalog {
	
	public static void listCatalog() {
		FileReader fr = null;
		BufferedReader br1 = null;
		try  {
			String fileName = "catalog.txt";
			File catalogFile = new File(fileName);
			fr = new FileReader(catalogFile);
			br1 = new BufferedReader(fr);
			String line = null;	
			while ((line = br1.readLine()) != null) {
		        System.out.println(line);     
		      }
		} catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		    }
		catch ( IOException e) {
			e.printStackTrace();
		}       			
		try {
			fr.close();
			br1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void addBookToLibrary (String bookIndentifier){
		String fileName = "catalog.txt";
		BufferedWriter outputStream = null;
		FileWriter fStream=null;
		try {
			fStream =new FileWriter(fileName, true);//true tells to append data.
			outputStream = new BufferedWriter (fStream);
			outputStream.write(bookIndentifier + "\n");
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteBookFromLibrary (String bookName){
		String fileName = "catalog.txt";
		File catalogFile = new File(fileName);
		File tempFile = new File(catalogFile.getAbsolutePath() + ".tmp");
		FileReader fr = null;
		BufferedReader br1 = null;
		PrintWriter pw = null;
		try  {
			fr = new FileReader(catalogFile);
			br1 = new BufferedReader(fr);
			pw = new PrintWriter(new FileWriter(tempFile));
			String line = null;	
			while ((line = br1.readLine()) != null) {
		    	Scanner sc = new Scanner (line);
		    	sc.useDelimiter(",");
		    	String temp = sc.next();
		    	if (!temp.equals(bookName)) {
		    		pw.println(line);
			        pw.flush();
			       }
		    	sc.close();
		      }
			br1.close();
			fr.close();
			br1 = null;
		    pw.close();
		    pw = null;
		    System.gc();
		   	    
		} catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		      try {
				br1.close();
				fr.close();
			    pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		      
		    }
		catch ( IOException e) {
			e.printStackTrace();
			try {
				br1.close();
				fr.close();
			    pw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
		}       		
		if (!catalogFile.delete()) {//delete old file
	        System.out.println("Could not delete file");
	      } 
		//Rename the new file to the filename the original file had.
		if (!tempFile.renameTo(catalogFile)){
			System.out.println("Could not rename file");
		}
	}
}
