package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bean.student;

@Controller
public class StudentController {
	@GetMapping("/student/form")
	public String form(Model model) {
		student student = new student();
		model.addAttribute("sv", student);
		return "student/form";
		
	}
	@PostMapping("/student/save")
	public String save(@ModelAttribute("sv") student form) {
		return "student/sussuces";
		
	}
}
