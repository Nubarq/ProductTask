package com.alas.task1.mapper;

import com.alas.task1.dto.ProductDetails.ProductDetailsRequestDto;
import com.alas.task1.dto.ProductDetails.ProductDetailsResponseDto;
import com.alas.task1.model.ProductDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DetailsMapper {

    ProductDetails mapProductDetailsRequestToEntity(ProductDetailsRequestDto requestDto);

    @Mapping(target="productId", source="product.id")
    ProductDetailsResponseDto mapEntityToProductDetailsResponse(ProductDetails productDetails);
}
