package com.alas.task1.service;

import com.alas.task1.dto.Product.ProductRequsetDto;
import com.alas.task1.dto.Product.ProductResponseDto;
import com.alas.task1.model.Product;

public interface ProductService {
    Product createProduct(ProductRequsetDto productRequsetDto);
    void delete(Integer id);
}
