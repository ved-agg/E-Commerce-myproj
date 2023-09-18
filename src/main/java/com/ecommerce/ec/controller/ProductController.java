package com.ecommerce.ec.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.ec.bean.ProductBean;
import com.ecommerce.ec.beanInput.ProductBeanInput;
import com.ecommerce.ec.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;
		
	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProductBean> listProduct() {
		log.trace("Get all the Products");
		return productService.getAllProducts();
	}
	
	@GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductBean getProductById(@PathVariable BigInteger id) {
		log.trace("Get Product with id {}", id);
		ProductBean product = productService.getProductByID(id);
		return product;
	}
	
	@PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductBean createProduct(@RequestBody ProductBeanInput inputProduct) {
		log.trace("Create Request for Product with input {}", inputProduct);
		return productService.createProduct(inputProduct.getId(), inputProduct.getName()
				,inputProduct.getDescription(), inputProduct.getPrice());
	}
	
	@DeleteMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void deleteById(@PathVariable BigInteger id) {
		log.trace("Delete Request for Product with input {}", id);
        productService.deleteById(id);
	}
	
	@DeleteMapping(value = "/products")
	public void deleteAll() {
		log.trace("Delete Request for Product");
        productService.deleteAllProduct();
	}
	
	//@RequestMapping(value = "/products/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PutMapping(value = "/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductBean updateProduct(@PathVariable BigInteger id, @RequestBody ProductBeanInput inputBean ) {
		log.trace("Create Request for product with id {} and input {}",id, inputBean);
		return productService.updateProduct(id, inputBean.getName(), inputBean.getDescription(), inputBean.getPrice());
	}
	
}
