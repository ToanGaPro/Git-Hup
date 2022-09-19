package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Categories;

public interface CategoryDAO extends JpaRepository<Categories, Integer> {

}
