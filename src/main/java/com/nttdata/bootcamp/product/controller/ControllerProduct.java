package com.nttdata.bootcamp.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.product.entity.Product;
import com.nttdata.bootcamp.product.entity.RequestproductDto;
import com.nttdata.bootcamp.product.entity.ResponseDelete;
import com.nttdata.bootcamp.product.service.IServiceProduct;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("product/v1")
public class ControllerProduct {

	@Autowired
	IServiceProduct serviceProduct;
	
	//@CircuitBreaker(name = "mycircuitbreaker", fallbackMethod = "fallback")
	//@TimeLimiter(name = "timelimit")
	//@Retry(name = "myRetry")
	@GetMapping(path = "/allproduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Product> getAll()
	{
		return serviceProduct.productFindAll();
	}
	
	//@CircuitBreaker(name = "mycircuitbreaker", fallbackMethod = "fallback")
	//@TimeLimiter(name = "timelimit")
	//@Retry(name = "myRetry")
	@GetMapping("/allproductbyid/{id}")
	public Mono<Product> getOne(@PathVariable String id)
	{
		return serviceProduct.productFindOne(id);
	}
	
	//@CircuitBreaker(name = "mycircuitbreaker", fallbackMethod = "fallback")
	//@TimeLimiter(name = "timelimit")
	//@Retry(name = "myRetry")
	@PostMapping(path = "/saveproduct", produces = MediaType.APPLICATION_JSON_VALUE
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Product> save(@RequestBody RequestproductDto body)
	{
		return serviceProduct.productSave(body);
	}
	
	//@CircuitBreaker(name = "mycircuitbreaker", fallbackMethod = "fallback")
	//@TimeLimiter(name = "timelimit")
	//@Retry(name = "myRetry")
	@PutMapping(path = "/updateclient", produces = MediaType.APPLICATION_JSON_VALUE
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Product> update(@RequestBody RequestproductDto body)
	{
		return serviceProduct.productUpdate(body);
	}
	
	//@CircuitBreaker(name = "mycircuitbreaker", fallbackMethod = "fallback")
	//@TimeLimiter(name = "timelimit")
	//@Retry(name = "myRetry")
	@DeleteMapping(path = "/deleteclient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseDelete> delete(@PathVariable String id)
	{
		return serviceProduct.productDelete(id);
	}
	
}
