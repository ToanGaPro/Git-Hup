package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderSe;
	
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Long id , Model model) {
		model.addAttribute("order", orderSe.findById(id));
		return "order/detail";
	}
	@RequestMapping("/order/list")
	public String list(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders", orderSe.findByUsername(username));
		return "order/list";
	}
}
