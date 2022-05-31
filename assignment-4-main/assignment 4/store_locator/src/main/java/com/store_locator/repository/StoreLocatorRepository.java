package com.store_locator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store_locator.entity.Store;
@Repository
public interface StoreLocatorRepository extends JpaRepository<Store, String>{

	
}
