package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AccountDAO;
import com.example.entity.Accounts;
import com.example.service.AccountService;

@Service
public class AccuontServiceImpl implements AccountService {
	@Autowired
	AccountDAO aDao;

	@Override
	public Accounts findById(String username) {
		return aDao.findById(username).get();
	}
	
	
}
