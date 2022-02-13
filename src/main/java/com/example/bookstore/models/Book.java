package com.example.bookstore.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

    @Id
    private String _id;
    private String name;
    private double price;
    private String author;
    private int quantity;
    private String url;
    private String description;

    public Book() {
    }

    public Book(String name, double price, String author, int quantity, String url, String description) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.quantity = quantity;
        this.url = url;
        this.description = description;
    }

    public Book(String _id, String name, double price, String author, int quantity, String url, String description) {
        this._id = _id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.quantity = quantity;
        this.url = url;
        this.description = description;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

