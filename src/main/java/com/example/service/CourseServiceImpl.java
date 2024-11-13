package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.repo.CourseRepository;


@Service
public  class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;

	
	public String upsert(Course course) {
		courseRepo.save(course);
		return "success";
	}

	
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
		
	}


	public Course getById(Integer cid) {
		Optional<Course> findById = courseRepo.findById(cid);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	
	public String deletebyid(Integer cid) {
		if(courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Delete sucess";
		} else {
		return "No Record Found";
	}

	}


}