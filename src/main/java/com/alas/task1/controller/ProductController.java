package com.alas.task1.controller;

import com.alas.task1.dto.Product.ProductRequsetDto;
import com.alas.task1.dto.Product.ProductResponseDto;
import com.alas.task1.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {
    private ProductService service;

    @PostMapping("/createProduct")
    public ProductResponseDto createProduct(@RequestBody ProductRequsetDto productRequsetDto) {
        return service.createProduct(productRequsetDto);
    }

}
