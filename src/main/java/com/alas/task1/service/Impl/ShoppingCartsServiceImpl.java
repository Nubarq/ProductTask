package com.alas.task1.service.Impl;

import com.alas.task1.dto.carts.ShoppingCartsRequestDto;
import com.alas.task1.dto.carts.ShoppingCartsResponseDto;
import com.alas.task1.exeption.CustomException;
import com.alas.task1.mapper.ShoppingCartsMapper;
import com.alas.task1.model.Product;
import com.alas.task1.model.ShoppingCarts;
import com.alas.task1.repository.ProductRepository;
import com.alas.task1.repository.ShoppingCartsRepository;
import com.alas.task1.service.ShoppingCartsService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ShoppingCartsServiceImpl implements ShoppingCartsService {

    ProductRepository productRepository;
    ShoppingCartsRepository cartsRepository;
    ShoppingCartsMapper cartsMapper;


    @Override
    public ShoppingCartsResponseDto addProduct(Integer cartId ,List<Integer> productIds) {
        ShoppingCarts carts = cartsRepository.findById(cartId).orElseThrow(() -> new CustomException("not found"));
        List<Product> products = productRepository.findAllById(productIds);
        carts.setProducts(products);
        return cartsMapper.mapEntityToShoppingCartResponse(carts);
    }

    @Override
    public ShoppingCartsResponseDto createCart(ShoppingCartsRequestDto cartsRequestDto) {
        ShoppingCarts shoppingCarts = cartsMapper.mapShoppingCartyRequestToEntity(cartsRequestDto);
        return cartsMapper.mapEntityToShoppingCartResponse(cartsRepository.save(shoppingCarts));
    }

    @Override
    public void removeProductFromCart(Integer cartId,List<Integer> productId) {
        ShoppingCarts carts = cartsRepository.findById(cartId).orElseThrow(() -> new CustomException("not found"));
        List<Product> productsToRemove = productRepository.findAllById(productId);
        carts.getProducts().removeAll(productsToRemove);
        cartsRepository.save(carts);
    }

    @Override
    public ShoppingCartsResponseDto getShoppingCartById(Integer cartId) {
        ShoppingCarts cart = cartsRepository.findById(cartId).orElseThrow(() -> new CustomException("not found"));
        return cartsMapper.mapEntityToShoppingCartResponse(cart);
    }


}
