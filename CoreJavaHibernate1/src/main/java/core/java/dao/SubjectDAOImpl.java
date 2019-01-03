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
import core.java.model.Subject;

public class SubjectDAOImpl implements SubjectDAO {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


	@Override
	public void addSubject(Subject subject) throws SQLException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(subject);
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteSubjectById(long subjectId) throws SQLException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query=  session.createQuery("delete from Subject where subjectId=:subjectid" );
		query.setParameter("subjectid", subjectId);
		int numberIfRowsUpdated =query.executeUpdate();	
		transaction.commit();
		session.close();
		System.out.println("Number of rows deleted are :"+numberIfRowsUpdated);
	}

	@Override
	public Subject getSubjectById(long subjectId) throws SQLException {
		Subject subject = new Subject();

		Session session = sessionFactory.openSession();
		Query query=  session.createQuery("from Subject where subjectId=:subjectid" );
		query.setParameter("subjectid", subjectId);
		List subjects = query.list();
		
		for(Iterator iterator= subjects.iterator();iterator.hasNext();) {
			subject = (Subject)iterator.next();
			System.out.println(subject.toString());
		}
		
		session.close();
		return subject;
	}

	@Override
	public List<Subject> getAllSubjects() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
