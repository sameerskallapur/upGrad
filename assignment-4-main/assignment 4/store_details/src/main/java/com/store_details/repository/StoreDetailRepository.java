package com.store_details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store_details.entity.Store;
@Repository
public interface StoreDetailRepository extends JpaRepository<Store, String> {

}
