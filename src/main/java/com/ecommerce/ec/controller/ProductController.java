package com.ecommerce.ec.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.ec.model.ProductEntity;
import com.ecommerce.ec.services.ProductService;

@Controller
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public String listProduct(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "product/list";
	}
	
	@GetMapping("/product/{id}")
	public String getProductById(@PathVariable BigInteger id, Model model) {
		ProductEntity product = productService.getProductByID(id).orElse(null);
		model.addAttribute("product", product);
		return "product/view";
	}
	
}
