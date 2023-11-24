package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDtos.AddTheaterRequest;
import com.example.BookMyShow.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class theaterController {

    @Autowired
    private TheaterService theaterService;


   @PostMapping("/addThrater")
   public ResponseEntity addTheater(AddTheaterRequest addTheaterRequest){
       String res=theaterService.addTheater(addTheaterRequest);
       return new ResponseEntity<>(res, HttpStatus.OK);
   }
}
