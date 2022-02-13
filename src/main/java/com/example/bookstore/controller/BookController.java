package com.example.bookstore.controller;

import com.example.bookstore.models.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("books",bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/admin/addbook")
    public String getAddBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/admin/addbook")
    public String postAddBook(@ModelAttribute("book")Book book){
        bookService.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/book/{id}")
    public String getBookById(@PathVariable("id") String id, Model model){
        Optional<Book> optionalBook = bookService.getBookById(id);
        optionalBook.ifPresentOrElse(book -> model.addAttribute("book", book), ()-> model.addAttribute("book",new Book()));
        return "bookdetail";
    }

    @GetMapping("/admin/delete/{bookId}")
    public String deleteBookById(@PathVariable("bookId") String bookId){
        bookService.deleteBookById(bookId);
        return "redirect:/";
    }

}
