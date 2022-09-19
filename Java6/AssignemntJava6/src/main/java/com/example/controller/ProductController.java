package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Products;
import com.example.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productServ;
	
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("oid") Optional<String> cid) { //isPresent() của Optional để kiểm tra tồn tại giá trị trước khi sử dụng
		if(cid.isPresent()) {
			List<Products> list = productServ.findByCategoryId(cid.get());
			model.addAttribute("items",list);
		}else {
			List<Products> list = productServ.findAll();
			model.addAttribute("items",list);
			
		}
		return "product/list";
	}
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model , @PathVariable("id") Integer id) {
		Products items = productServ.findById(id);
		model.addAttribute("items", items);
		return "product/detail";
	}
}
