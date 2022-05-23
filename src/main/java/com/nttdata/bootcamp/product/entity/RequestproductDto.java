package com.nttdata.bootcamp.product.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestproductDto implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -978656594240307136L;

	private Product product;
	
	public Product toProduct()
	{
		return Product.builder()
				.id(this.product.getId())
				.description(this.product.getDescription())
				.category(this.product.getCategory())
				.build();
	}
	
}
