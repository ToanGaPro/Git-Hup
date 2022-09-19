package com.example.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bean.Students;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class StudentController {
	@RequestMapping("/student")
	public String index(Model model,
			@RequestParam("index") Optional<Integer> index) throws Exception{
	ObjectMapper mapper = new ObjectMapper();
	File path = ResourceUtils.getFile("classpath:com/example/bean/student.json");
	TypeReference<List<Students>> typeref = new TypeReference<>() {
	};
		List<Students> students = mapper.readValue(path, typeref);
		int i = index.orElse(0);
		model.addAttribute("n", i);
		model.addAttribute("sv", students.get(i));
		return "scope/student";
	}
}
