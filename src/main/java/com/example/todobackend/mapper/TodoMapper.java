package com.example.todobackend.mapper;


import com.example.todobackend.model.dto.request.TodoDTO;
import com.example.todobackend.model.dto.respond.RespTodo;
import com.example.todobackend.model.entity.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    public TodoDTO todoEntityToTodoDto(Todo todo){
        return TodoDTO.builder()
                .title(todo.getTitle())
                .description(todo.getDescription())
                .isCompleted(todo.isCompleted())
                .build();
    }

    public RespTodo todoEntityToTodoResp(Todo todo){
        return RespTodo.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .isCompleted(todo.isCompleted())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .active(todo.getActive())
                .build();
    }
    public Todo todoDtoEntityToTodoEntity(TodoDTO todoDto){
        return Todo.builder()
                .title(todoDto.getTitle())
                .description(todoDto.getDescription())
                .isCompleted(todoDto.isCompleted())
                .build();
    }
}
