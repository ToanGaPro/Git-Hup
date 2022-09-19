package com.example.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScopeController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	@Autowired
	ServletContext servletcontext;
	@RequestMapping("/scope")
	public String index(Model model) {
		 session.setAttribute("c", "Im am in session scope");
		servletcontext.setAttribute("d", "I am in Application Scope");
		request.setAttribute("b","I am in Request scope");
		model.addAttribute("a","I am in model");
		return "scope/index";
	}
}
