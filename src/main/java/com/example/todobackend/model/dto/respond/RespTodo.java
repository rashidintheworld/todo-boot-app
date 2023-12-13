package com.example.todobackend.model.dto.respond;

import com.example.todobackend.utils.StaticMessage;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespTodo {
    Long id;
    String title;
    String description;
    boolean isCompleted;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Integer active;
}
