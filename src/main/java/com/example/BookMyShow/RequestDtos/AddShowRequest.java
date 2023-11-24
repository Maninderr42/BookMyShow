package com.example.BookMyShow.RequestDtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
public class AddShowRequest {

    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private Integer theaterId;
}
