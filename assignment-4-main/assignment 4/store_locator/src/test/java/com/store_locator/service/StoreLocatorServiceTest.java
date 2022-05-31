package com.store_locator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.store_locator.entity.Store;
import com.store_locator.repository.StoreLocatorRepository;
@SpringBootTest
class StoreLocatorServiceTest {
	@Autowired
	private StoreLocatorService storeLocatorService;
	
	private Store store = new Store();
	 private Store store1 = new Store();
	
	@MockBean
	private StoreLocatorRepository storeLocatorRepository;

	@Test
	void testGetStoreDetails() {
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
		
		Mockito.when(storeLocatorService.getStoreDetails("111")).thenReturn(stores);
		
		String pincode = "111";
		List<Store> storeDetails = storeLocatorService.getStoreDetails(pincode);
	    assertEquals(pincode, storeDetails.get(0).getPincode());
		
		
	}

}
