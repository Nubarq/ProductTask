package com.alas.task1.dto.carts;

import com.alas.task1.model.Product;
import lombok.Data;

import java.util.List;
@Data
public class ShoppingCartsRequestDto {
    //private List<Product> products;
    private String name;
    private List<Integer> productIds;


}
