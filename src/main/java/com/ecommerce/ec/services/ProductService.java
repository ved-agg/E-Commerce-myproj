package com.ecommerce.ec.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ec.model.ProductEntity;
import com.ecommerce.ec.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	//get all products
	public List<ProductEntity> getAllProducts(){
		return productRepository.findAll();
	}
	//get product by ID
	public Optional<ProductEntity> getProductByID(BigInteger id){
		return productRepository.findById(id);
	}
	//create new product
	public ProductEntity createProduct(ProductEntity product) {
		return productRepository.save(product);
	}
	//delete all products
	public void deleteAllProduct() {
		productRepository.deleteAll();
	}
	//delete by id
	public void deleteById(BigInteger id) {
		productRepository.deleteById(id);
	}
	
	public ProductEntity updateProduct(BigInteger id, ProductEntity product) {
		Optional<ProductEntity> prod = productRepository.findById(id);
		if(prod.isPresent()) {
			ProductEntity pr = prod.get();
			pr.setDescription(product.getDescription());
			pr.setName(product.getName());
			pr.setPrice(product.getPrice());
			return productRepository.save(pr);
		}
		return null;
	}
	
	
}
