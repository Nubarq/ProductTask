package com.alas.task1.controller;

import com.alas.task1.dto.carts.ShoppingCartsRequestDto;
import com.alas.task1.dto.carts.ShoppingCartsResponseDto;
import com.alas.task1.service.ShoppingCartsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ShoppingController {
    private ShoppingCartsService cartsService;

    @PostMapping("/addProductToCart")
    public ShoppingCartsResponseDto addProductToCart(@RequestParam Integer cartId,@RequestParam List<Integer> productIds) {
        return cartsService.addProduct(cartId, productIds);
    }


    @PostMapping("/createShoppingCart")
    public ShoppingCartsResponseDto createCart(@RequestBody ShoppingCartsRequestDto cartsRequestDto) {
        return cartsService.createCart(cartsRequestDto);
    }


    @DeleteMapping("/removeProductFromCart")
    public void removeProductFromCart(@RequestParam Integer cartId,@RequestParam List<Integer> productId) {
        cartsService.removeProductFromCart(cartId,productId);
    }


    @GetMapping("/getShoppingCartById")
    public ShoppingCartsResponseDto getShoppingCartById(@RequestParam Integer cartId) {
        return cartsService.getShoppingCartById(cartId);
    }
    }
