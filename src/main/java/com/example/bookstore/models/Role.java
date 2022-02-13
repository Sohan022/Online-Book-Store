package com.example.bookstore.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role {

    @Id
    private String _id;
    private String role;

    public Role() {
    }

    public Role(String _id, String role) {
        this._id = _id;
        this.role = role;
    }

    public Role(String role) {
        this.role = role;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "_id='" + _id + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
