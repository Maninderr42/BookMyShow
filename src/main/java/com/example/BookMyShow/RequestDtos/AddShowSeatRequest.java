package com.example.BookMyShow.RequestDtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddShowSeatRequest {


    private Integer showId;

    private Integer priceOfClassicSeats;

    private Integer priceOfPremiumSeats;

}
