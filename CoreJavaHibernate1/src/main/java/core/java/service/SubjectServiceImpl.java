package core.java.service;


import java.sql.SQLException;
import java.util.List;
import core.java.dao.SubjectDAO;
import core.java.dao.SubjectDAOImpl;
import core.java.model.Subject;

public class SubjectServiceImpl implements SubjectService{
	SubjectDAO subjectdao = new SubjectDAOImpl();

	@Override
	public void addSubject(Subject subject) {
		try {
			subjectdao.addSubject(subject);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Subject searchSubjectbyId(long subjectId) {
		Subject subject = new Subject();
		try {
			subject = subjectdao.getSubjectById(subjectId);
		} catch (SQLException e) {
			System.out.println("No Subject found wih ihis ID");
			e.printStackTrace();
		}
		return subject;
	}
	
	@Override	
	public void deleteSubjectbyId(long subjectId) {
		try {
			subjectdao.deleteSubjectById(subjectId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Subject> getAllSubjects() {
		return null;
	}
}

