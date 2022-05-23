package com.nttdata.bootcamp.product.service;

import com.nttdata.bootcamp.product.entity.Product;
import com.nttdata.bootcamp.product.entity.RequestproductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IServiceProduct {

	Flux<Product> productFindAll();
	
	Flux<Product> productFindAll(String[] ids);
	
	Mono<Product> productFindOne(String id);
	
	Mono<Product> productSave(RequestproductDto request);
	
	Mono<Product> productUpdate(RequestproductDto request);
	
	Mono<Void> productDelete(String id);
	
}
