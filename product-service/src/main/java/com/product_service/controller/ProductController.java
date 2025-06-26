package com.product_service.controller;

import com.product_service.client.Dto.ProductResponse;
import com.product_service.service.ProductService;
import com.product_service.utils.ApiResponse;
import com.product_service.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getProducts(){
        List<ProductResponse> productResponses = productService.getProducts();
        return ResponseUtils.buildSuccessResponse(productResponses, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(@PathVariable Integer id){
        ProductResponse productResponse = productService.getProductById(id);
        return ResponseUtils.buildSuccessResponse(productResponse, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ProductResponse>> saveProduct(@RequestBody ProductResponse productResponse){
        ProductResponse savedProduct = productService.saveProduct(productResponse);
        return ResponseUtils.buildSuccessResponse(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ProductResponse>> updateProduct(@PathVariable Integer id, @RequestBody ProductResponse productResponse){
        ProductResponse updatedProduct = productService.updateProduct(id, productResponse);
        return ResponseUtils.buildSuccessResponse(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseUtils.buildSuccessResponse(null,HttpStatus.NO_CONTENT);
    }

}
