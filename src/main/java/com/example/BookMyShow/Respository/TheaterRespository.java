package com.example.BookMyShow.Respository;

import com.example.BookMyShow.Models.Theater;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRespository extends JpaRepository<Theater, Integer> {
}
