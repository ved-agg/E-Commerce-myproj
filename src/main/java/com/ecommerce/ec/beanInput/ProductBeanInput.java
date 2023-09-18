package com.ecommerce.ec.beanInput;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.ecommerce.ec.bean.ProductBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBeanInput {
	private BigInteger id;
	private String name;
	private String description;
	private BigDecimal price;
}
