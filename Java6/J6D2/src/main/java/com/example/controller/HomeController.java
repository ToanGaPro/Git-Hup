package com.example.controller;



import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bean.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	@RequestMapping("/home/index")
	public String index(Model model) throws Exception {
		model.addAttribute("message","Welcome to Thyleaf");
		ObjectMapper mapper = new ObjectMapper();
		String path = "C:\\Users\\Admin\\Music\\Java6\\J6D2\\src\\main\\resources\\static\\student.json";
		Student student = mapper.readValue(new File(path),Student.class);
		model.addAttribute("sv", student);
		return "home/index";
	}
}
