package com.example.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OrderDetails;


public interface OrderDetailDAO extends JpaRepository<OrderDetails, Long> {

	

}
