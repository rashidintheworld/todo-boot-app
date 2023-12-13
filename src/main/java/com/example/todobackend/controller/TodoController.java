package com.example.todobackend.controller;

import com.example.todobackend.model.dto.request.TodoDTO;
import com.example.todobackend.model.dto.respond.RespTodo;
import com.example.todobackend.model.dto.respond.Response;
import com.example.todobackend.service.TodoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/todos")
public class TodoController {
    private final TodoService todoService;
    @GetMapping("/{id}")
    public Response<RespTodo> getTodoById(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @PostMapping("/new")
    public Response<RespTodo> saveTodo(@Valid @RequestBody TodoDTO todoDTO) {
        return todoService.saveTodo(todoDTO);
    }

    @GetMapping("/all")
    public Response<List<RespTodo>> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PatchMapping("/{id}")
    public Response deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public Response updateTodo(@PathVariable Long id, @Valid @RequestBody TodoDTO todoDto) {
        return todoService.updateTodo(id, todoDto);
    }

    @PutMapping("/{id}/completion")
    public ResponseEntity<String> markTodoAsCompleted(@PathVariable Long id) {
        todoService.completeTodo(id);
        return ResponseEntity.ok("Todo marked as completed.");
    }

    @PutMapping("/{id}/incompletion")
    public ResponseEntity<String> markTodoAsIncomplete(@PathVariable Long id) {
        todoService.inCompleteTodo(id);
        return ResponseEntity.ok("Todo marked as incomplete.");
    }
}
