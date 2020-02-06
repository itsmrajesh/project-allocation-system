package com.proj.dao;

import java.util.List;

import com.proj.domain.MyProject;
import com.proj.domain.Student;

public interface Dao {
	boolean signUpStudent(Student student); // ok

	Student getStudent(String usn); // ok

	boolean registerProject(MyProject project); // ok

	List<MyProject> getStudentProject(String usn); // ok

	boolean updateProject(int pid, String status, String feedback); // ok

	MyProject getProjectByID(int pid); // ok

	Student loginStudent(String email, String password); // ok

}
