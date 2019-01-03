package core.java.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.java.dao.BookDAO;
import core.java.dao.BookDAOImpl;
import core.java.model.Book;

public class BookServiceImpl implements BookService{
	BookDAO bookdao = new BookDAOImpl();
	
	@Override
	public void addBook(Book book) {
		try {
			bookdao.addBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Book searchBookbyId(long bookId) {
		Book book = null;
		try {
			book = bookdao.getBookById(bookId);
		} catch (SQLException e) {
			System.out.println("No Book found wih ihis ID" );
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public void deleteBookbyId(long bookId) {
		try {
			bookdao.deleteBookById(bookId);
		} catch (SQLException e) {
			System.out.println("No Book found wih ihis ID");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> listbook = new <Book>ArrayList();
		return listbook;
	}
	

	
}
