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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDTO {
    @NotNull(message = StaticMessage.NOT_NULL_MESSAGE)
    @NotEmpty(message = StaticMessage.NOT_EMPTY_MESSAGE)
    String name;
    @NotNull(message = StaticMessage.NOT_NULL_MESSAGE)
    @NotEmpty(message = StaticMessage.NOT_EMPTY_MESSAGE)
    String username;
    @NotNull(message = StaticMessage.NOT_NULL_MESSAGE)
    @NotEmpty(message = StaticMessage.NOT_EMPTY_MESSAGE)
    String email;
    @NotNull(message = StaticMessage.NOT_NULL_MESSAGE)
    @NotEmpty(message = StaticMessage.NOT_EMPTY_MESSAGE)
    String password;
}
