package com.store_details.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.store_details.entity.Store;
import com.store_details.repository.StoreDetailRepository;

@Service
public class StoreDetailsService {
	@Autowired
	private StoreDetailRepository repo;
	@Autowired
	private RestTemplate restTemplate;

	public Store saveStoreDetails(Store store) {
		return repo.save(store);
	}

	public List<Store> getAllStoresDetails(String pincode) {
		Store[] storeDetails = restTemplate.getForObject("http://STORELOCATOR-SERVICE/storeLocator/"+pincode,Store[].class);
		return Arrays.asList(storeDetails);
	}

}
