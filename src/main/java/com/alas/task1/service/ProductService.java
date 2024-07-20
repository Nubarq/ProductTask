package com.alas.task1.service;

import com.alas.task1.dto.Product.ProductRequsetDto;
import com.alas.task1.dto.Product.ProductResponseDto;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequsetDto productRequsetDto);
    void delete(Integer id);
}
