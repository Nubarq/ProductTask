package com.alas.task1.mapper;

import com.alas.task1.dto.Product.ProductRequsetDto;
import com.alas.task1.dto.Product.ProductResponseDto;
import com.alas.task1.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    @Mapping(target = "category.id", source = "categoryId")
    Product mapProductRequestToEntity(ProductRequsetDto requestDto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductResponseDto mapEntityToProductResponse(Product product);
}
