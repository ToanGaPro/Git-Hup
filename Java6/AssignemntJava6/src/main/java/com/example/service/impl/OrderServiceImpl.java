package com.example.service.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.OrderDAO;
import com.example.dao.OrderDetailDAO;
import com.example.entity.OrderDetails;
import com.example.entity.Orders;
import com.example.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO orDao;
	
	@Autowired
	OrderDetailDAO ordeDao;
	
	@Override
	public Orders create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Orders order = mapper.convertValue(orderData,Orders.class);
		orDao.save(order);
		
	    TypeReference<List<OrderDetails>> type = new TypeReference<List<OrderDetails>>() {};
	    List<OrderDetails> details = mapper.convertValue(orderData.get("orderDetails"), type)
	    		.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
	    ordeDao.saveAll(details);
		return order;
	}

	@Override
	public Orders findById(Long id) {
		return orDao.findById(id).get();
	}

	@Override
	public List<Orders> findByUsername(String username) {
		return orDao.findByUsername(username);
	}

}
