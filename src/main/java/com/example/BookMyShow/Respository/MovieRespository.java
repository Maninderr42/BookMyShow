package com.example.BookMyShow.Respository;

import com.example.BookMyShow.Models.Movie;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRespository extends JpaRepository<Movie,Integer> {

    Movie findMovieByMovieName(String movieNmae);
}
