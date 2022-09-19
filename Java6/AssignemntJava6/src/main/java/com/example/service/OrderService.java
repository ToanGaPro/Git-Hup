package com.example.service;

import java.util.List;

import com.example.entity.Orders;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrderService {
	Orders create(JsonNode orderData);

	Orders findById(Long id);

	List<Orders> findByUsername(String username);

}
