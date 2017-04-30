package com.test.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.test.entity.Student;
import com.test.service.IStudentService;

@RestController
public class StudentController {
	
	@Autowired
	private IStudentService iStudentService;
	
	@RequestMapping("/getstu")
	public HashMap<String, Object> getStudents(@RequestParam(value="parameter") String parameter,
			@RequestParam(value="pageNum")int pageNum, @RequestParam(value="pageSize")int pageSize) {
		HashMap<String, Object> studentMap = new HashMap<String, Object>();
		Page<Student> page = iStudentService.getStudents(parameter, pageNum, pageSize);
		studentMap.put("studentdata", page);
		studentMap.put("number", page.getTotal());
		return studentMap;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)  
	public void add(@RequestParam(value="name") String name) {  
		iStudentService.addStudents(name);
	}  
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)  
	public void delete(@RequestParam(value="array[]") int[] array)
	{
		iStudentService.deleteStudents(array);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST) 
	public void update(@RequestParam(value="id")int id, @RequestParam(value="name")String name)
	{
		iStudentService.updateStudents(id, name);
	}
}
