package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface Product_Repository extends JpaRepository<Product, Integer> {

}
