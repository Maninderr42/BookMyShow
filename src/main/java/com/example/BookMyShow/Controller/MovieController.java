package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDtos.AddMovieRequest;
import com.example.BookMyShow.Service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
@Slf4j
public class MovieController{

    @Autowired
    private MovieService movieService;


    @PostMapping("addmovie")
    public ResponseEntity addMvovie(@RequestBody AddMovieRequest addMovieRequest){
        try{
            log.info("We have Request: {}" , addMovieRequest.toString());
            String res=movieService.addMovie(addMovieRequest);
            return new ResponseEntity(res, HttpStatus.OK);


        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
