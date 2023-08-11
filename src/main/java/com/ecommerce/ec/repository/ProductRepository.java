package com.ecommerce.ec.repository;

import java.math.BigInteger;

import com.ecommerce.ec.model.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, BigInteger>{

}
