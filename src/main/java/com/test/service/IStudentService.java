package com.test.service;

import com.github.pagehelper.Page;
import com.test.entity.Student;

public interface IStudentService {
	public Page<Student> getStudents(String parameter, int pageNum, int pageSize);
	public void addStudents(String name);
	public void deleteStudents(int[] id);
	public void updateStudents(int id, String new_name);
}
