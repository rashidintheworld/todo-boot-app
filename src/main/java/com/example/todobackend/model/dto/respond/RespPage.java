package com.example.todobackend.model.dto.respond;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespPage {
    List<RespTodo> todoList;
    long pageNo;
    int pageSize;
    boolean hasNextPage;
}
