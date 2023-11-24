package com.example.BookMyShow.Service;

import com.example.BookMyShow.RequestDtos.BookTicketRequest;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public String bookTicket(BookTicketRequest bookTicketRequest) {
        return "added";


    }
}
