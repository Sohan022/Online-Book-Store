package com.example.bookstore.controller;

import com.example.bookstore.models.Book;
import com.example.bookstore.models.CartItem;
import com.example.bookstore.models.CustomUserDetail;
import com.example.bookstore.models.User;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.CartService;
import com.example.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String getCart(Authentication authentication, Model model){
        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();
        String userId = customUserDetail.getId();
        List<CartItem> cartItems = cartService.getCartItems(userId);
        double totalPrice = 0;
        for(CartItem cartItem: cartItems){
            totalPrice += cartItem.getBook().getPrice() * cartItem.getQuantity();
        }
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("totalItems",cartItems.size());
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/addtocart/{bookId}")
    public String addToCart(@RequestParam int quantity, @PathVariable String bookId, Authentication authentication){
        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();
        String userId = customUserDetail.getId();
        Optional<User> user = userService.getUserById(userId);
        if(user.isEmpty()) return "redirect:/login";

        Optional<Book> book = bookService.getBookById(bookId);
        if(book.isEmpty()) return "redirect:/";

        CartItem cartItem = new CartItem(book.get(),userId,quantity);
        cartService.addToCart(cartItem);

        return "redirect:/cart";
    }

    @GetMapping("/cart/{cartItemId}")
    public String deleteCartItemById(@PathVariable String cartItemId){
        cartService.deleteByCartId(cartItemId);
        return "redirect:/cart";
    }
}
