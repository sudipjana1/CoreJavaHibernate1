package core.java.service;



import java.util.List;

import core.java.model.Book;

public interface BookService {

	public void addBook(Book book);
	public Book searchBookbyId(long bookId);
	public void deleteBookbyId(long bookId) ;
	public List<Book> getAllBooks();
}
