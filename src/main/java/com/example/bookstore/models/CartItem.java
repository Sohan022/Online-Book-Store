package com.example.bookstore.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CartItem {

    @Id
    private String _id;

    @DBRef
    private Book book;

    private String userId;
    private int quantity;

    public CartItem() {
    }

    public CartItem(String _id, Book book, String userId, int quantity) {
        this._id = _id;
        this.book = book;
        this.userId = userId;
        this.quantity = quantity;
    }

    public CartItem(Book book, String userId, int quantity) {
        this.book = book;
        this.userId = userId;
        this.quantity = quantity;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "_id='" + _id + '\'' +
                ", book=" + book +
                ", userId='" + userId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
