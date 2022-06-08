package com.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.dto.Order;
import com.ordermanagement.entity.OrderEntity;
import com.ordermanagement.service.OrderManagementService;

@RestController
public class OrderManagementController {
	
	@Autowired
	private OrderManagementService orderManagementService;
	
	@PostMapping("/ordermngmt/placeOrder")
	public 	ResponseEntity<String>  placeOrderr(@RequestBody Order order) {
		String message = null;
		try {
			orderManagementService.placeOrder(order);
			message = "Placing Order success";
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
	}
	
	@GetMapping("/ordermngmt/getOrerById/{id}")
	public ResponseEntity<OrderEntity> getOrerById(@PathVariable("id") int id){
		OrderEntity orderEntity = null;
		try {
			orderEntity = orderManagementService.getOrderById(id);
			if (orderEntity == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<OrderEntity>(orderEntity , HttpStatus.OK);
	}
	
	@GetMapping("/ordermngmt/getOrerByPincode/{pincode}")
	public ResponseEntity<List<OrderEntity>> getOrerByPincode(@PathVariable("pincode") String pincode){
		List<OrderEntity> orderEntity = null;
		try {
			orderEntity = orderManagementService.getOrderByPincode(pincode);
			if (orderEntity == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<OrderEntity>>(orderEntity , HttpStatus.OK);
	}

}
