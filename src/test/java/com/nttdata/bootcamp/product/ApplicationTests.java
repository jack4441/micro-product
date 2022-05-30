package com.nttdata.bootcamp.product;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.nttdata.bootcamp.product.controller.ControllerProduct;
import com.nttdata.bootcamp.product.entity.Product;
import com.nttdata.bootcamp.product.entity.RequestproductDto;
import com.nttdata.bootcamp.product.entity.ResponseDelete;
import com.nttdata.bootcamp.product.repository.ProductRepository;
import com.nttdata.bootcamp.product.service.ServiceProduct;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@WebFluxTest(ControllerProduct.class)
class ApplicationTests {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private ProductRepository pro;
	@MockBean
	private ServiceProduct service;

	@Test
	void registerProduct() {
		RequestproductDto prod = new RequestproductDto();
		Product product = Product.builder()
							.description("product 1")
							.category("category")
							.build();
		prod.setProduct(product);
		when(service.productSave(prod)).thenReturn(Mono.just(prod.toProduct()));
		
		webTestClient.post().uri("/product/v1/saveproduct")
			.bodyValue(prod)
			.exchange()
			.expectStatus().isOk();
	}

	@Test
	void updateProduct() {
		RequestproductDto prod = new RequestproductDto();
		Product product = Product.builder()
							.id("62853d233bb9de122e044c64")
							.description("ahorro")
							.category("pasivo")
							.build();
		prod.setProduct(product);
		when(service.productSave(prod)).thenReturn(Mono.just(prod.toProduct()));
		
		webTestClient.put().uri("/product/v1/updateclient")
			.bodyValue(prod)
			.exchange()
			.expectStatus().isOk();
	}
	
	@Test
	void deleteClient()
	{
		String idprod = "62853d233bb9de122e044c64";
		ResponseDelete reponse = ResponseDelete.builder().response("Operación completada").build();
		given(service.productDelete(any())).willReturn(Mono.just(reponse));
		webTestClient.delete().uri("/product/v1/deleteclient/"+idprod)
			.exchange()
			.expectStatus().isOk();
		
	}
	
}
