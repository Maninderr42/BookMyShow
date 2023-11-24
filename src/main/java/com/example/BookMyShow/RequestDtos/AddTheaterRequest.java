package com.example.BookMyShow.RequestDtos;


import com.example.BookMyShow.Enum.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddTheaterRequest {

    private String name;

    private String address;

    private Integer noOfPremiumSeats;

    private Integer noOfClassicSeats;

    private City city;

    private  Integer noOfSeatPerRow;
}
