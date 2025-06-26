package com.product_service.service.impl;

import com.product_service.client.Dto.ProductResponse;
import com.product_service.client.ProductFeignClient;
import com.product_service.exception.BadRequestException;
import com.product_service.exception.ResourceNotFoundException;
import com.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductFeignClient productFeignClient;

    @Autowired
    public ProductServiceImpl(ProductFeignClient productFeignClient){
        this.productFeignClient = productFeignClient;
    }

    @Override
    public List<ProductResponse> getProducts() {
        return productFeignClient.getProducts();
    }

    @Override
    public ProductResponse getProductById(Integer id) {
        ProductResponse productResponse = productFeignClient.getProductById(id);
        if (productResponse == null){
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        return productResponse;
    }

    @Override
    public ProductResponse saveProduct(ProductResponse productResponse) {
        return productFeignClient.saveProduct(productResponse);
    }

    @Override
    public ProductResponse updateProduct(Integer id, ProductResponse productResponse) {

        ProductResponse existing = productFeignClient.getProductById(id);

        if (existing == null) {
            throw new ResourceNotFoundException("Unable to update: product with id does not exist " + id);
        }
        // Opcional: fomentar que el id en el body coincida con el pathVariable:
        if (productResponse.getId() != null && !productResponse.getId().equals(id)) {
            throw new BadRequestException("The id of the body must match the id in the URL");
        }
        return productFeignClient.updateProduct(id, productResponse);
    }

    @Override
    public void deleteProduct(Integer id) {
        ProductResponse existing = productFeignClient.getProductById(id);
        if(existing == null){
          throw new ResourceNotFoundException("Unable delete: product with id does not exist " + id);
        }
        productFeignClient.deleteProduct(id);
    }


}
