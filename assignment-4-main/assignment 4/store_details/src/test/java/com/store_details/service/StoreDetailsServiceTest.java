package com.store_details.service;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.store_details.entity.Store;
import com.store_details.repository.StoreDetailRepository;
@SpringBootTest
class StoreDetailsServiceTest {

	@Autowired
	private StoreDetailsService storeDetailsService;
	
	@MockBean
	private StoreDetailRepository storeDetailRepository;
	
	 private Store store = new Store();
	 private Store store1 = new Store();
	
	
	@Test
	public void saveStoreDetailsTest() {
		
		store.setStoreId("abc");
		store.setStoreName("trends");
		store.setAddressLine1("atp");
		store.setAddressLine2("atp");
		store.setState("ap");
		store.setCountry("india");
		store.setPincode("111");
		store.setEmail("trends@gmail.com");
		
		Mockito.when(storeDetailsService.saveStoreDetails(store)).thenReturn(store);
		
		String id = "abc";
		Store storeDetails = storeDetailsService.saveStoreDetails(store);
	    assertEquals(id, storeDetails.getStoreId());

		
	}
	
	@Test
	public void getAllStoresDetailsTest() {
		
		store.setStoreId("abc");
		store.setStoreName("trends");
		store.setAddressLine1("atp");
		store.setAddressLine2("atp");
		store.setState("ap");
		store.setCountry("india");
		store.setPincode("111");
		store.setEmail("trends@gmail.com");
		
		store1.setStoreId("abc1");
		store1.setStoreName("trends1");
		store1.setAddressLine1("atp");
		store1.setAddressLine2("atp");
		store1.setState("ap");
		store1.setCountry("india");
		store1.setPincode("111");
		store1.setEmail("trends1@gmail.com");
		
		List<Store> stores = new ArrayList<>();
		stores.add(store);
		stores.add(store1);
		
		Mockito.when(storeDetailsService.getAllStoresDetails("111")).thenReturn(stores);
		
		String pincode = "111";
		List<Store> storeDetails = storeDetailsService.getAllStoresDetails(pincode);
	    assertEquals(pincode, storeDetails.get(0).getPincode());

		
	}
	

}
