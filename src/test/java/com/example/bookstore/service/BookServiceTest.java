package com.example.bookstore.service;

import com.example.bookstore.models.Book;
import com.example.bookstore.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

//    @BeforeEach
//    void setUp(){
//        this.bookService = new BookService(this.bookRepository);
//    }

    @Test
    void getAllBooks() {
        bookService.getAllBooks();
        verify(bookRepository).findAll();
    }

    @Test
    void addBook() {
        Book book = new Book("Kaizen",357,"Harvey Sarah",5,"https://rukminim1.flixcart.com/image/416/416/k1gr2q80/book/3/5/6/kaizen-the-japanese-method-for-transforming-habits-one-small-original-imafhyhk7brcehza.jpeg?q=70","Self-Help");
        bookService.addBook(book);
        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        verify(bookRepository).save(bookArgumentCaptor.capture());
        Book capturedBook = bookArgumentCaptor.getValue();
        assertThat(capturedBook).isEqualTo(book);
    }

    @Test
    void getBookById() {
        bookService.getBookById(anyString());
        verify(bookRepository).findById(anyString());
    }
}