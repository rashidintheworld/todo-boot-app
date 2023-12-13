package com.example.todobackend.repository;

import com.example.todobackend.model.entity.Role;
import com.example.todobackend.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoUtilityRepository extends JpaRepository<Todo,Long> {
    @Query("SELECT t FROM Todo t WHERE " +
            "t.title LIKE CONCAT('%', :query, '%')" + "Or t.description LIKE CONCAT('%', :query, '%')")
    List<Todo> searchProducts(String query);

    @Query("SELECT t FROM Todo t ORDER BY LOWER(t.title) ASC")
    List<Todo> findAllByTitleOrderByAsc();

    @Query("SELECT t FROM Todo t ORDER BY LOWER(t.title) DESC")
    List<Todo> findAllByTitleOrderByDesc();
}
