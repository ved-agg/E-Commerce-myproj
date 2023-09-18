package com.ecommerce.ec.bean;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.ecommerce.ec.model.IEntity;
import com.ecommerce.ec.model.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBean {

	private BigInteger id;
	private String name;
	private String description;
	private BigDecimal price;
	
}
