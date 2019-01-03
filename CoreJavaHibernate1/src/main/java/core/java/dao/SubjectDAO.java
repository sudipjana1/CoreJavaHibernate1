package core.java.dao;

import java.sql.SQLException;
import java.util.List;

import core.java.model.Subject;

public interface SubjectDAO {
	public void addSubject(Subject subject) throws SQLException;
	public void deleteSubjectById(long subject) throws SQLException;
	public Subject getSubjectById(long subjectid) throws SQLException;
	public List<Subject> getAllSubjects() throws SQLException;
}
