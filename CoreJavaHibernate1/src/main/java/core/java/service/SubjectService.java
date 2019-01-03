package core.java.service;


import java.util.List;
import core.java.model.Subject;

public interface SubjectService {

	public void addSubject(Subject book);
	public Subject searchSubjectbyId(long subjectId);
	public void deleteSubjectbyId(long subjectId) ;
	public List<Subject> getAllSubjects();

}

