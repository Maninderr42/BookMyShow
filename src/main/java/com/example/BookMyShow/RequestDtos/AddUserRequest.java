package com.example.BookMyShow.RequestDtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {

    private String name;

    private String email;

    private String mobNo;

    private Integer age;
}
