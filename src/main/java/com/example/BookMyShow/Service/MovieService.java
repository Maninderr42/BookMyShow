package com.example.BookMyShow.Service;


import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.RequestDtos.AddMovieRequest;
import com.example.BookMyShow.Respository.MovieRespository;
import com.example.BookMyShow.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRespository movieRespository;

    public String addMovie(AddMovieRequest addMovieRequest) throws Exception{


        Movie movie= MovieTransformer.convertmovieDataToModelMovie(addMovieRequest);

        movieRespository.save(movie);

        return "Add Movie DB SuccessFully............";


    }
}
