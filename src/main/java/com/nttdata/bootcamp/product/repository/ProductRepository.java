package com.nttdata.bootcamp.product.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.product.entity.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
