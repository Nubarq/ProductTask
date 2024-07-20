package com.alas.task1.dto.ProductDetails;

import com.alas.task1.model.Product;
import lombok.Data;

import java.util.List;
@Data
public class ProductDetailsResponseDto {
    private String color;
    private String image_url;
    private Integer productId;
}
