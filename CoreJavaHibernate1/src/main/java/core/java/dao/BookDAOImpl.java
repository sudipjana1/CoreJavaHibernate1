package core.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import core.java.model.Book;

public class BookDAOImpl implements BookDAO {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public void addBook(Book book) throws SQLException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(book);
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteBookById(long bookId) throws SQLException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query=  session.createQuery("delete from Book where bookId=:bookid" );
		query.setParameter("bookid", bookId);
		int numberIfRowsUpdated =query.executeUpdate();	
		transaction.commit();
		session.close();
		System.out.println("Number of rows deleted are :"+numberIfRowsUpdated);
	}

	@Override
	public Book getBookById(long bookId) throws SQLException {
		Book book = new Book();

		Session session = sessionFactory.openSession();
		Query query=  session.createQuery("from Book where bookId=:bookid" );
		query.setParameter("bookid", bookId);
		List books = query.list();
		
		for(Iterator iterator= books.iterator();iterator.hasNext();) {
			book = (Book)iterator.next();
			System.out.println(book.toString());
		}
		
		session.close();
		return book;
	}

	@Override
	public List<Book> getAllBooks() throws SQLException {

		Session session = sessionFactory.openSession();
		Query query=  session.createQuery("from Book" );
		List<Book> books = query.list();		
		session.close();
		return books;
	}

}
