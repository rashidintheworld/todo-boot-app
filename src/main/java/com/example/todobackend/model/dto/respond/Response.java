package com.example.todobackend.model.dto.respond;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Response<T> {
    @JsonProperty(value = "data")
    T t;
    @JsonProperty(value = "status")
    RespStatus respStatus;
}
