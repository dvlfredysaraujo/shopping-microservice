package com.product_service.service;

import com.product_service.client.Dto.ProductResponse;
import java.util.List;

public interface ProductService {
    public List<ProductResponse> getProducts();

    public ProductResponse getProductById(Integer id);

    public ProductResponse saveProduct(ProductResponse productResponse);

    public ProductResponse updateProduct(Integer id, ProductResponse productResponse);

    public void deleteProduct(Integer id);
}
