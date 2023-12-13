package com.example.todobackend.service;

import com.example.todobackend.enums.SortDirectionEnum;
import com.example.todobackend.model.dto.respond.RespPage;
import com.example.todobackend.model.dto.respond.RespTodo;
import com.example.todobackend.model.dto.respond.Response;

import java.util.List;

public interface TodoUtilityService {
    Response<List<RespTodo>> searchTodos(String query);
    Response<List<RespTodo>> getAllTodosSortedByTitle(SortDirectionEnum sortDirection);
}