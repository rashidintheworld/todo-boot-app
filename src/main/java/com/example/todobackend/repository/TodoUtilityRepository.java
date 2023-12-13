package com.example.todobackend.repository;

import com.example.todobackend.model.entity.Role;
import com.example.todobackend.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoUtilityRepository extends JpaRepository<Todo,Long> {
    @Query("SELECT p FROM Todo p WHERE " +
            "p.title LIKE CONCAT('%', :query, '%')" + "Or p.description LIKE CONCAT('%', :query, '%')")
    List<Todo> searchProducts(String query);
    
}
