package com.product_service.client;

import com.product_service.client.Dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "api-external-products", url = "${external.api.url}")
public interface ProductFeignClient {

    @GetMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> getProducts();

    @GetMapping(value = "/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse getProductById(@PathVariable Integer id);

    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse saveProduct(@RequestBody ProductResponse productResponse);

    @PutMapping(value = "/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse updateProduct(@PathVariable Integer id, @RequestBody ProductResponse productResponse);

    @DeleteMapping(value = "/products/{id}")
    public void deleteProduct(@PathVariable Integer id);

}
