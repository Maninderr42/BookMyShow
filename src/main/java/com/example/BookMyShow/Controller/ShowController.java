package com.example.BookMyShow.Controller;


import com.example.BookMyShow.RequestDtos.AddShowRequest;
import com.example.BookMyShow.RequestDtos.AddShowSeatRequest;
import com.example.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController{

    @Autowired
    private ShowService showService;

    @PostMapping("/addshow")
    public ResponseEntity addShow(@RequestBody AddShowRequest addShowRequest) {
        try {
            String res = showService.addShow(addShowRequest);
            return new ResponseEntity(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
    }
        @PostMapping("/createShowSeats")
                public String enableshowSeats(@RequestBody AddShowSeatRequest addShowSeatRequest ){
        String res=showService.createShowSeats(addShowSeatRequest);
        return res;
        }



}
