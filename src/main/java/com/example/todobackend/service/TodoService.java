package com.example.todobackend.service;

import com.example.todobackend.model.dto.request.TodoDTO;
import com.example.todobackend.model.dto.respond.RespPage;
import com.example.todobackend.model.dto.respond.RespTodo;
import com.example.todobackend.model.dto.respond.Response;
import com.example.todobackend.model.entity.Todo;

import java.util.List;

public interface TodoService {
    Response<RespTodo> getTodo(Long id);
    Response<RespTodo> saveTodo(TodoDTO todoDTO);
    RespPage getAllTodo(int pageNo, int pageSize);
    Response deleteTodo(Long id);
    Response updateTodo(Long id, TodoDTO todoDTO);

    //additional
    void completeTodo(Long id);
    void inCompleteTodo(Long id);
}
