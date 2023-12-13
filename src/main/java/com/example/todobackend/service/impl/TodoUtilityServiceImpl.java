package com.example.todobackend.service.impl;

import com.example.todobackend.mapper.TodoMapper;
import com.example.todobackend.model.dto.respond.RespPage;
import com.example.todobackend.model.dto.respond.RespStatus;
import com.example.todobackend.model.dto.respond.RespTodo;
import com.example.todobackend.model.dto.respond.Response;
import com.example.todobackend.model.entity.Todo;
import com.example.todobackend.repository.TodoRepository;
import com.example.todobackend.repository.TodoUtilityRepository;
import com.example.todobackend.service.TodoUtilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoUtilityServiceImpl implements TodoUtilityService {
    private final TodoUtilityRepository todoUtilityRepository;
    private final TodoMapper todoMapper;

    @Override
    public Response<List<RespTodo>> searchTodos(String query) {
        Response<List<RespTodo>> response = new Response<>();
        List<Todo> todoList = todoUtilityRepository.searchProducts(query);
        List<RespTodo> respTodoList = todoList.stream().map(todoMapper::todoEntityToTodoResp).toList();
        response.setT(respTodoList);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }
}
