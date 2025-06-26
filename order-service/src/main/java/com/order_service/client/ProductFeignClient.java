package com.order_service.client;

import com.order_service.client.dto.ProductResponse;
import com.order_service.client.dto.ProductSpecifications;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "${product.service.url}/api/products")
public interface ProductFeignClient {

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductSpecifications> getProducts();

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse getProductById(@PathVariable("id") Integer id);
}
