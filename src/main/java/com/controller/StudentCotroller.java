package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mapper.StudentMapper;
import com.model.Student;

@Controller
@RequestMapping("/student")
public class StudentCotroller {
	
	@Autowired
	StudentMapper studentmapper;
	
//	@RequestMapping("/list")
//	public @ResponseBody List<Student> listAllStudent(){
//		List<Student> students = studentmapper.selectAllStudent();
//		ModelAndView mav = new ModelAndView("list");
//		mav.addObject("students", students);
//		return students;
//	}
	
}
