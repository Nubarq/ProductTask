package com.alas.task1.service;

import com.alas.task1.dto.carts.ShoppingCartsRequestDto;
import com.alas.task1.dto.carts.ShoppingCartsResponseDto;

import java.util.List;


public interface ShoppingCartsService {
    ShoppingCartsResponseDto addProduct(Integer cartId, List<Integer> productIds);

    ShoppingCartsResponseDto createCart(ShoppingCartsRequestDto cartsRequestDto);

    void removeProductFromCart(Integer cartId,List<Integer> productId);
    ShoppingCartsResponseDto getShoppingCartById(Integer cartId);
}
