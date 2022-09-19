package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Orders;



public interface OrderDAO extends JpaRepository<Orders, Long> {
	@Query("SELECT o FROM Orders o WHERE o.account.username=?1")
	List<Orders> findByUsername(String username);
}
