package com.example.BookMyShow.Service;

import com.example.BookMyShow.Controller.ShowController;
import com.example.BookMyShow.Enum.SeatType;
import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.RequestDtos.AddShowRequest;
import com.example.BookMyShow.RequestDtos.AddShowSeatRequest;
import com.example.BookMyShow.Respository.MovieRespository;
import com.example.BookMyShow.Respository.ShowRespository;
import com.example.BookMyShow.Respository.TheaterRespository;
import com.example.BookMyShow.Transformers.ShowTransfomer;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ShowService {

    @Autowired
    private ShowRespository showRespository;

    @Autowired
    private MovieRespository movieRespository;

    @Autowired
    private TheaterRespository theaterRespository;


    public String addShow(AddShowRequest addShowRequest) throws Exception{

        Show show= ShowTransfomer.convertshowRequest(addShowRequest);

        Movie movie=movieRespository.findMovieByMovieName(addShowRequest.getMovieName());

        Optional<Theater> optionalTheater=theaterRespository.findById(addShowRequest.getTheaterId());
        if(!optionalTheater.isPresent()){
            throw new Exception("theater Id id Not Valid");
        }
        Theater theater=optionalTheater.get();

        show.setMovie(movie);
        show.setTheater(theater);

        theater.getShowList().add(show);
        movie.getShowList().add(show);

        show=showRespository.save(show);

        return "Show has been saved Db SuccessFully.........";







    }

    public String createShowSeats(AddShowSeatRequest addShowSeatRequest){

        Show show=showRespository.findById(addShowSeatRequest.getShowId()).get();

        Theater theater=show.getTheater();

        List<TheaterSeat> theaterSeatList=theater.getTheaterSeatList();

        List<ShowSeat> showSeatList =new ArrayList<>();

        for(TheaterSeat theaterSeat:theaterSeatList){

            ShowSeat showSeat=ShowSeat.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .isAvailable(true)
                    .isFoodAttached(false)
                    .show(show)
                    .build();

            if(theaterSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setCost(addShowSeatRequest.getPriceOfClassicSeats());
            }else{
                showSeat.setCost(addShowSeatRequest.getPriceOfPremiumSeats());
            }
            showSeatList.add(showSeat);

        }

        show.setShowSeatList(showSeatList);

        showRespository.save(show);

        return "The Show Seats added  SuccessFully.........";



    }
}
