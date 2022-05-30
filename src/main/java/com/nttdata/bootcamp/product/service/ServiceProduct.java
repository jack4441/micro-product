package com.nttdata.bootcamp.product.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.product.entity.Product;
import com.nttdata.bootcamp.product.entity.RequestproductDto;
import com.nttdata.bootcamp.product.entity.ResponseDelete;
import com.nttdata.bootcamp.product.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ServiceProduct implements IServiceProduct {

	@Autowired
	ProductRepository productdao;
	
	@Override
	public Flux<Product> productFindAll() {
		// TODO Auto-generated method stub
		return productdao.findAll();
	}

	@Override
	public Mono<Product> productFindOne(String id) {
		// TODO Auto-generated method stub
		return productdao.findById(id);
	}

	@Override
	public Mono<Product> productSave(RequestproductDto request) {
		// TODO Auto-generated method stub
		if(request.getProduct().getId()==null)
			return productdao.save(request.toProduct());
		else
			return Mono.empty();
	}

	@Override
	public Mono<Product> productUpdate(RequestproductDto request) {
		// TODO Auto-generated method stub
		if(request.getProduct().getId()==null)
			return productdao.findById(request.getProduct().getId()).map(e-> request.toProduct()).flatMap(productdao::save);
		else
			return Mono.empty();
	}

	@Override
	public Mono<ResponseDelete> productDelete(String id) {
		// TODO Auto-generated method stub
		productdao.deleteById(id).block(); 
		return Mono.just(ResponseDelete.builder().response("Operación completada").build());
	}

	@Override
	public Flux<Product> productFindAll(String[] ids) {
		// TODO Auto-generated method stub
		return productdao.findAllById(Stream.of(ids).map(e->e.toString()).collect(Collectors.toList()));
	}

}
