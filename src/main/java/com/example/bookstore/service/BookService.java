package com.example.bookstore.service;

import com.example.bookstore.models.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void addBook(Book book){

        bookRepository.save(book);
    }

    public Optional<Book> getBookById(String id){
        return bookRepository.findById(id);
    }

    public void deleteBookById(String id){
        bookRepository.deleteById(id);
    }
}
