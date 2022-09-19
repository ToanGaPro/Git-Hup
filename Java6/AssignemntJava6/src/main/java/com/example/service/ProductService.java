package com.example.service;

import java.util.List;

import com.example.entity.Products;

public interface ProductService {
	List<Products> findAll();
	
	Products findById(Integer id);
	
	List<Products> findByCategoryId(String cid);

	Products create(Products product);

	Products update(Products sproduct);

	void delete(Integer id);
}
