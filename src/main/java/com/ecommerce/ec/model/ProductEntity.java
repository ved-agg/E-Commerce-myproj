package com.ecommerce.ec.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.ecommerce.ec.bean.ProductBean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements IEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
	private BigInteger id;
	
	private String name;
	private String description;
	private BigDecimal price;
	
	@Override
	public ProductBean getBeanFromEntity() {
		return new ProductBean(id, name, description, price);
	}
}
