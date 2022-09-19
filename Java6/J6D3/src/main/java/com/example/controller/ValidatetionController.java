package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.bean.student2;
@Controller
public class ValidatetionController {
	@GetMapping("/validatetion/form")
	public String form(Model model) {
		student2 student = new student2();
		model.addAttribute("sv", student);
		return "validatetion/form";
		
	}
	@PostMapping("/validatetion/validate")
	public String validate(Model model , @Validated @ModelAttribute("sv") student2 form ,Errors error) {
		if(error.hasErrors()) {
			model.addAttribute("message", "Vui long nhap lai loi!");
			return "validatetion/form";
		}
		return "validatetion/sussuces";
		
	}
}
