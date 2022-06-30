package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entities.ProductEntity;
import com.ecommerce.pojos.Product;
import com.ecommerce.services.ProductServices;

@RestController
public class ECommerceController {

	@Autowired
	private ProductServices productServices;

	@PostMapping("/product/add")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		String message = null;
		try {
			productServices.addProduct(product);
			message = "Adding product success";
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(message);

	}

	@GetMapping("/product/view/{productName}/{model}")
	public ResponseEntity<ProductEntity> viewProduct(@PathVariable("productName") String productName,
			@PathVariable("model") String model) {
		ProductEntity prod = productServices.viewProduct(productName, model);
		if (prod == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductEntity>(prod, HttpStatus.OK);
	}
	
	@GetMapping("/product/search/{productName}/{model}/{minAmount}/{maxAmount}")
	public ResponseEntity<ProductEntity> searchProduct(@PathVariable("productName") String productName, 
			@PathVariable("model") String model,
			@PathVariable("minAmount") String minAmount, @PathVariable("maxAmount") String maxAmount){
		ProductEntity prod = productServices.searchProduct(productName, model,minAmount,maxAmount);
		if (prod == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductEntity>(prod, HttpStatus.OK);
	}

}
