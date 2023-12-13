package com.example.todobackend.service.impl;

import com.example.todobackend.builder.TodoMapper;
import com.example.todobackend.exception.ResourceNotFoundException;
import com.example.todobackend.exception.TodoException;
import com.example.todobackend.model.dto.request.TodoDTO;
import com.example.todobackend.model.dto.respond.RespStatus;
import com.example.todobackend.model.dto.respond.RespTodo;
import com.example.todobackend.model.dto.respond.Response;
import com.example.todobackend.model.entity.Todo;
import com.example.todobackend.repository.TodoRepository;
import com.example.todobackend.service.TodoService;
import com.example.todobackend.utils.StaticMessage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public Todo checkExistence(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(StaticMessage.NOT_FOUND_MESSAGE));
    }

    @Override
    public Response<RespTodo> getTodo(Long id) {
        Response<RespTodo> response = new Response<>();
        Todo todo = checkExistence(id);
        RespTodo respTodo = todoMapper.todoEntityToTodoResp(todo);
        response.setT(respTodo);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }

    @Override
    public Response<RespTodo> saveTodo(TodoDTO todoDTO) {
        Response<RespTodo> response = new Response<>();
        Todo todo = todoRepository.save(todoMapper.todoDtoEntityToTodoEntity(todoDTO));
        RespTodo respDto = todoMapper.todoEntityToTodoResp(todo);
        response.setT(respDto);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }

    @Override
    public Response<List<RespTodo>> getAllTodos() {
        Response<List<RespTodo>> response = new Response<>();
        List<Todo> todoList = todoRepository.findAll();
        List<RespTodo> respTodoList = todoList.stream().map(todoMapper::todoEntityToTodoResp).toList();
        response.setT(respTodoList);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }
    
    @Override
    public Response deleteTodo(Long id) {
        Response response = new Response();
        Todo todo = checkExistence(id);
        if (todo.getActive() == 1) {
            todo.setActive(0);
            todoRepository.save(todo);
        } else {
            new TodoException(StaticMessage.ACTIVE_WARN_MESSAGE);
        }
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }

    @Override
    public Response updateTodo(Long id, TodoDTO todoDTO) {
        Response response = new Response();
        Todo todo = checkExistence(id);
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setCompleted(todoDTO.isCompleted());
        todoRepository.save(todo);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }

    @Override
    public void completeTodo(Long id) {
        Todo todo = checkExistence(id);
        todo.setCompleted(Boolean.TRUE);
        todoRepository.save(todo);
    }
    @Override
    public void inCompleteTodo(Long id) {
        Todo todo = checkExistence(id);
        todo.setCompleted(Boolean.FALSE);
        todoRepository.save(todo);
    }
}
