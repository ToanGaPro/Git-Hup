package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Accounts;

public interface AccountDAO extends JpaRepository<Accounts, String>{

}
