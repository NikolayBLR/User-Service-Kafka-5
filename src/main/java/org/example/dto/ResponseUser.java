package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public class ResponseUser {
    private String name;
    private String email;
    private Integer age;

}

