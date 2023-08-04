package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.repository.Product_Repository;

@RestController
public class Product_Controller {

	@Autowired
	Product_Repository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Product_Controller.class);
	
//=========================================================================================================
//**************************************************** : CRUD : *******************************************
//=========================================================================================================
	
	// Read Operation | Op:1
	// localhost:8585/product_info/products/getAll
	
	@RequestMapping(value = "/products/getAll", method = RequestMethod.GET)
	public List<Product> getAll() {
		return repository.findAll();
	}
	
//=========================================================================================================
	
	// Read by Id Operation | Op:2
	// localhost:8585/product_info/products/{id}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		LOGGER.info("Finding product by ID:"+id);
		return repository.findById(id).get();
	}
	
//=========================================================================================================
	
	//  Create Operation | Op:3
	//  localhost:8585/product_info/products/store

	@RequestMapping(value = "/products/store", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
//=========================================================================================================
	
	//  Update Operation | Op:4
	//  localhost:8585/product_info/products/update

	@RequestMapping(value = "/products/update", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
//=========================================================================================================
	
	//  Delete Operation | Op:5
	//  localhost:8585/product_info/products/delete/{id}

	@RequestMapping(value = "/products/delete/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
	
//=========================================================================================================
//=========================================================================================================

}