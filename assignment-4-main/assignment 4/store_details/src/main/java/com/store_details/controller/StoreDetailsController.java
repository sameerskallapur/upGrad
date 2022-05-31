package com.store_details.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store_details.entity.Store;
import com.store_details.service.StoreDetailsService;

@RestController
public class StoreDetailsController {
	@Autowired
	private StoreDetailsService service;
	
	@PostMapping("/storeDetails")
	public Store saveStoreDetails(@Valid @RequestBody Store store) {
		return service.saveStoreDetails(store);
	}
	
	@GetMapping("/storeDetails/{pincode}")
	public List<Store> getAllStoresDetails(@PathVariable String pincode){
		return service.getAllStoresDetails(pincode);
	}
	
	

}
