package com.example.BookMyShow.Respository;

import com.example.BookMyShow.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRespository extends JpaRepository<Ticket,Integer> {
}
