package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@RequestMapping("/hello.th")
	public String hello(Model model) {
		model.addAttribute("message","FPT POLYTECHNIC");
		return "hello";
	}
}
