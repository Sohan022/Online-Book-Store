package com.example.bookstore.repository;

import com.example.bookstore.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository  extends MongoRepository<Role,String> {
    Optional<Role> findByRole(String role);
}
