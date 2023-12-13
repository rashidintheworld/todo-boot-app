package com.example.todobackend.model.dto.request;

import com.example.todobackend.utils.StaticMessage;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TodoDTO {
    @NotNull(message = StaticMessage.NOT_NULL_MESSAGE)
    @NotEmpty(message = StaticMessage.NOT_EMPTY_MESSAGE)
    String title;
    @NotNull(message = StaticMessage.NOT_NULL_MESSAGE)
    @NotEmpty(message = StaticMessage.NOT_EMPTY_MESSAGE)
    String description;
    boolean isCompleted;
}
