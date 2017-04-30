package com.test.Dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.test.entity.Student;

public interface StudentMapper {
	public List<Student> getStudents(@Param("parameter")String parameter);
	public void addStudents(@Param("name")String name);
	public void deleteStudents(@Param("ids")int[] id);
	public void updateStudents(int id, String new_name);
}
