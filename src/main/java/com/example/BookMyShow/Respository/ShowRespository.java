package com.example.BookMyShow.Respository;

import com.example.BookMyShow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRespository extends JpaRepository<Show, Integer> {
}
