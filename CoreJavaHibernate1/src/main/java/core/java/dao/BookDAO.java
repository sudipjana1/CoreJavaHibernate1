package core.java.dao;

import java.sql.SQLException;
import java.util.List;

import core.java.model.Book;

public interface BookDAO {
	
	public void addBook(Book book) throws SQLException;
	public void deleteBookById(long bookid) throws SQLException;
	public Book getBookById(long bookid) throws SQLException;
	public List<Book> getAllBooks() throws SQLException;

}
