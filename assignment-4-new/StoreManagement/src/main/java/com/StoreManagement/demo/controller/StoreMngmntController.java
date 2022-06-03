package com.StoreManagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StoreManagement.demo.entities.StoreEntity;
import com.StoreManagement.demo.pojos.Store;
import com.StoreManagement.demo.services.StoreService;

@RestController
public class StoreMngmntController {

	@Autowired
	private StoreService storeService;
	
	
	@PostMapping("/addStore")
	public StoreEntity addStore(@RequestBody Store newStore) {
		StoreEntity store = storeService.addStore(newStore);
		return store;
	}
	
	@GetMapping("/getStoreDetails/{id}")
	public ResponseEntity<StoreEntity> getStoreDetails(@PathVariable("id") String storeId){
		 StoreEntity store = storeService.getStore(storeId);
		if (store == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StoreEntity>(store , HttpStatus.OK);
	}
	
	@GetMapping("/getStoresOnPincode/{pincode}")
	public ResponseEntity<List<StoreEntity>> getStoreDetailsOnPincpde(@PathVariable("pincode") String pincode){
		 List<StoreEntity> store = storeService.getStoresOnPincode(pincode);
		if (store == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<StoreEntity>>(store , HttpStatus.OK);
	}
}
