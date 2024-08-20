package com.fred.apirest.com.fred.apirest.repository;

import com.fred.apirest.com.fred.apirest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//mark it with repository annotation

public interface ProductRepository extends JpaRepository<Product, Long> {

}
