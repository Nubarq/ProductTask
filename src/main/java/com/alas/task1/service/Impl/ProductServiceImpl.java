package com.alas.task1.service.Impl;

import com.alas.task1.dto.Product.ProductRequsetDto;
import com.alas.task1.dto.Product.ProductResponseDto;
import com.alas.task1.mapper.ProductMapper;
import com.alas.task1.model.Product;
import com.alas.task1.repository.ProductRepository;
import com.alas.task1.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {
    ProductMapper mapper;
    ProductRepository repository;

    @Override
    public ProductResponseDto createProduct(ProductRequsetDto productRequsetDto) {
        Product product = mapper.mapProductRequestToEntity(productRequsetDto);
        return mapper.mapEntityToProductResponse(repository.save(product));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
