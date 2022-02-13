package com.example.bookstore.service;

import com.example.bookstore.models.CartItem;
import com.example.bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void addToCart(CartItem cartItem){
        cartRepository.save(cartItem);
    }

    public List<CartItem> getCartItems(String userId){
        return cartRepository.findAllByUserId(userId);
    }

    public Optional<CartItem> getCartItemById(String cartItemId){
        return cartRepository.findById(cartItemId);
    }

    public void deleteByCartId(String cartItemId){
        cartRepository.deleteById(cartItemId);
    }
}
