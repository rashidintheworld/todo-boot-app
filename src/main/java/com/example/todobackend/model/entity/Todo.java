package com.example.todobackend.model.entity;

import com.example.todobackend.utils.StaticMessage;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull(message = StaticMessage.NOT_NULL_MESSAGE)
    @NotEmpty(message = StaticMessage.NOT_EMPTY_MESSAGE)
    String title;
    String description;

    boolean isCompleted;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    Integer active;

    @PrePersist
    public void prePersist() {
        if(active == null) {
            active = 1; //We set default value in case if the value is not set yet.
        }
    }
}
