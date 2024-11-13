package com.example.service;

import java.util.List;

import com.example.entity.Course;

public interface CourseService {
	
	
	public String  upsert (Course course);
	
	public  List <Course> getallCourses();
	
	public Course getbyId(Integer cid);
	
	public String deletebyid(Integer cid);

}
