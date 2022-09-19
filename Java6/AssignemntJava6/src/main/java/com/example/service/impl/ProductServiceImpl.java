package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDAO;
import com.example.entity.Products;
import com.example.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO pDao;
	@Override
	public List<Products> findAll() {
		return pDao.findAll();
	}

	@Override
	public Products findById(Integer id) {
		return pDao.findById(id).get();
	}
	
	@Override
	public List<Products> findByCategoryId(String cid) {
		return pDao.findByCategory(cid);
	}

	@Override
	public Products create(Products product) {
		return pDao.save(product);
	}

	@Override
	public Products update(Products product) {
		return pDao.save(product);
	}

	@Override
	public void delete(Integer id) {
		pDao.deleteById(id);
	}
}
