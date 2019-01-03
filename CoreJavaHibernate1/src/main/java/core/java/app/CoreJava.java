package core.java.app;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import core.java.model.Book;
import core.java.model.Subject;
import core.java.service.BookService;
import core.java.service.BookServiceImpl;
import core.java.service.SubjectService;
import core.java.service.SubjectServiceImpl;

public class CoreJava {
    public static Scanner scanner = new Scanner(System.in);
    public static BookService bs = new BookServiceImpl();
    public static SubjectService ss = new SubjectServiceImpl();

	public static void main(String[] args) {
		
		try {			
            int menuOption = 0;
            do {
                // Setting menuOption equal to return value from showMenu();
                menuOption = showMenu();

                // Switching on the value given from user
                switch (menuOption) {

                case 1:
                    System.out.println("Add Subject...");
                    Subject subject = showAddSubjectMenu();
                    ss.addSubject(subject);
                    break;
                case 2:
                    System.out.println("Add Book...");
                    Book book = showAddBookMenu();
            			bs.addBook(book);
                    break;
                case 3:
                    System.out.println("Delete Subject...");
                    ss.deleteSubjectbyId(searchSubjectMenu());
                    break;
                case 4:
                    System.out.println("Delete Book...");
                    bs.deleteBookbyId(searchBookMenu());
                    break;
                case 5:
                    System.out.println("Search Book...");
                    bs.searchBookbyId(searchBookMenu());
                    break;
                case 6:
                    System.out.println("Search Subject...");
                    ss.searchSubjectbyId(searchSubjectMenu());
                    break;
                case 7:
                    System.out.println("Quitting Program...");
                    break;
                default:
                    System.out.println("Sorry, please enter valid Option");

                }// End of switch statement

            } while (menuOption != 7);
		}catch (Exception ex) {
            // Error Message
            System.out.println("Sorry problem occured within Program");
            ex.printStackTrace();
            // flushing scanner
            scanner.next();
        } finally {
            // Ensuring that scanner will always be closed and cleaning up
            // resources
            scanner.close();
        }
	}
	
	public static int showMenu() {

        int selection;

        /***************************************************/

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Add Subject");
        System.out.println("2 - Add Book");
        System.out.println("3 - Delete Subject");
        System.out.println("4 - Delete Book");
        System.out.println("5 - Search for a Book");
        System.out.println("6 - Search for a Subject");
        System.out.println("7 - Exit");
        
        
        selection = scanner.nextInt();
        return selection;    
    }
	
	public static Book showAddBookMenu() {

        Book book = new Book();

        /***************************************************/
/*
        System.out.println("Enter Book ID:");        
        book.setBookId(scanner.nextInt());*/
        System.out.println("Enter Book Price:");        
		book.setPrice(scanner.nextDouble());
		book.setPublishDate(new Date());
        System.out.println("Enter Book Title:");        
		book.setTitle(scanner.next());
        System.out.println("Enter Book Volume:");        
		book.setVolume(scanner.nextInt());
        
        return book;    
    }
	
	public static int searchBookMenu() {
        /***************************************************/

        System.out.println("Enter Book ID:");                
        return scanner.nextInt();    
    }
	
	@SuppressWarnings("null")
	public static Subject showAddSubjectMenu() {

        Subject subject = new Subject();

        /***************************************************/

        /*System.out.println("Enter Subject ID:");        
        subject.setSubjectId(scanner.nextInt());*/
        System.out.println("Enter Subject Title:");  
        subject.setSubtitle(scanner.next());
		System.out.println("Enter Subject Duration:");        
		subject.setDurationInHours(scanner.nextInt());
        System.out.println("Enter Books:"); 
        List<Book> references = new ArrayList<Book>();
        references.add(bs.searchBookbyId(searchBookMenu()));
        references.add(bs.searchBookbyId(searchBookMenu()));

		subject.setReferences(references);

        
        return subject;    
    }
	
	public static int searchSubjectMenu() {
        /***************************************************/

        System.out.println("Enter Subject ID:");                
        return scanner.nextInt();    
    }
}
