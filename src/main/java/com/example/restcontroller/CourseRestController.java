package com.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Course;
import com.example.service.CourseService;

public class CourseRestController {
	
	@RestController
	
	
	@RequestMapping

	    @Autowired
	    private CourseService courseService;

	    // Create or update course
	    @PostMapping("/course")
	    public ResponseEntity<String> createCourse(@RequestBody Course course) {
	        String status = courseService.upsert(course);
	        return new ResponseEntity<>(status, HttpStatus.CREATED);
	    }

	    // Get a course by its ID
	    @GetMapping("/course/{cid}")
	    public ResponseEntity<Course> getCourse(@PathVariable Integer cid) {
	        Course course = courseService.getbyId(cid);
	        return new ResponseEntity<>(course, HttpStatus.OK);
	    }

	    // Get all courses
	    @GetMapping("/courses")
	    public ResponseEntity<List<Course>> getAllCourses() {
	        List<Course> allCourses = courseService.getallCourses();
	        return new ResponseEntity<>(allCourses, HttpStatus.OK);
	    }

	    // Update course
	    @PutMapping("/course")
	    public ResponseEntity<String> updateCourse(@RequestBody Course course) {
	        String status = courseService.upsert(course);
	        return new ResponseEntity<>(status, HttpStatus.OK);
	    }

	    // Delete a course by its ID
	    @DeleteMapping("/course/{cid}")
	    public ResponseEntity<String> deleteCourse(@PathVariable Integer cid) {
	        String status = courseService.deletebyid(cid);
	        return new ResponseEntity<>(status, HttpStatus.OK);
	    }
	}

