package com.example.todobackend.model.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespStatus {
    private Integer code;
    private String message;

    private static final Integer SUCCES_CODE=1;
    private static final String SUCCES_MESSAGE="SUCCES";

    public static RespStatus getSuccesMessage(){
        return new RespStatus(SUCCES_CODE,SUCCES_MESSAGE);
    }
}
