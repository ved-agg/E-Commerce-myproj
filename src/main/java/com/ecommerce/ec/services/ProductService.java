package com.ecommerce.ec.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ec.bean.ProductBean;
import com.ecommerce.ec.model.ProductEntity;
import com.ecommerce.ec.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	//get all products
	public List<ProductBean> getAllProducts(){
		return productRepository.findAll().stream().map(ProductEntity::getBeanFromEntity).collect(Collectors.toList());
	}
	//get product by ID
	public ProductBean getProductByID(BigInteger id){
		return getProductEntity(id).getBeanFromEntity();
	}
	//create new product
	public ProductBean createProduct(BigInteger id, String name, String description, BigDecimal price) {
		ProductEntity addNewProduct = new ProductEntity(id, name, description, price);
		return productRepository.save(addNewProduct).getBeanFromEntity();
	}
	//delete all products
	public void deleteAllProduct() {
		productRepository.deleteAll();
	}
	//delete by id
	public void deleteById(BigInteger id) {
		productRepository.deleteById(id);
	}
	
	public ProductBean updateProduct(BigInteger id, String name, String description, BigDecimal price) {
		ProductEntity prod = getProductEntity(id);
		if(prod != null) {
			prod.setDescription(description);
			prod.setName(name);
			prod.setPrice(price);
		}
		return productRepository.save(prod).getBeanFromEntity();
	}
	
	private ProductEntity getProductEntity(BigInteger id) {
		return productRepository.findById(id).orElseThrow(() -> new ProviderNotFoundException("Product Id : "+id+" not found "));
	}	
}
