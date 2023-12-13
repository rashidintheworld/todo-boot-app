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
@Builder

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = StaticMessage.NOT_NULL_MESSAGE)
    @NotEmpty(message = StaticMessage.NOT_EMPTY_MESSAGE)
    String name;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    Integer active;
    @PrePersist
    public void prePersist() {
        if(active == null) //We set default value in case if the value is not set yet.
            active = 1;
    }
}
