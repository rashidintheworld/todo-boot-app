package com.example.todobackend.controller;


import com.example.todobackend.enums.SortDirectionEnum;
import com.example.todobackend.model.dto.respond.RespPage;
import com.example.todobackend.model.dto.respond.RespTodo;
import com.example.todobackend.model.dto.respond.Response;
import com.example.todobackend.service.TodoUtilityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/todos")
public class TodoUtilityController {
    TodoUtilityService todoUtilityService;

    @GetMapping("/search")
    public Response<List<RespTodo>> searchTodos(@RequestParam(value = "query")  String query) {
        return todoUtilityService.searchTodos(query);
    }

    @GetMapping("/sortBy")
    public Response<List<RespTodo>> getAllSortedTodos(@RequestParam(value = "dir") SortDirectionEnum sortDirectionEnum) {
        return todoUtilityService.getAllTodosSortedByTitle(sortDirectionEnum);
    }
}
