package com.example.BookMyShow.Service;

import com.example.BookMyShow.Enum.SeatType;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Models.TheaterSeat;
import com.example.BookMyShow.RequestDtos.AddTheaterRequest;
import com.example.BookMyShow.Respository.TheaterRespository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TheaterService {


    @Autowired
    private TheaterRespository theaterRespository;
    public String addTheater(AddTheaterRequest addTheaterRequest){

        Theater theater=Theater.builder()
                .name(addTheaterRequest.getName())
                .city(addTheaterRequest.getCity())
                .address(addTheaterRequest.getAddress())
                .build();

        createTheaterSeats(theater,addTheaterRequest);

        return "Theater Sucessfully Added to the DB..............";


    }

    public void createTheaterSeats(Theater theater, AddTheaterRequest addTheaterRequest){

        int noOfClassicSeats=addTheaterRequest.getNoOfClassicSeats();
        int noOfPermiumSeats=addTheaterRequest.getNoOfPremiumSeats();
        int noOfSeatsPerRow=addTheaterRequest.getNoOfSeatPerRow();


        List<TheaterSeat> theaterSeatList=new ArrayList<>();

        int row=0;
        char ch='A';

        for(int i=1; i<=noOfClassicSeats; i++){

            if(i%noOfSeatsPerRow==1){
                row++;
                ch='A';
            }

            String seatNo=row+""+ch;
            ch++;

            TheaterSeat theaterSeat=TheaterSeat.builder()
                    .seatNo(seatNo)
                    .theater(theater)
                    .seatType(SeatType.CLASSIC)
                    .build();

            theaterSeatList.add(theaterSeat);


        }

        ch='A';

        for(int i=1; i<=noOfPermiumSeats; i++){

            if(i%noOfPermiumSeats==1){
                row++;
                ch='A';
            }
            String seatNo=row+""+ch;
            ch=(char)(ch+1);

            TheaterSeat theaterSeat=TheaterSeat.builder()
                    .seatNo(seatNo)
                    .theater(theater)
                    .seatType(SeatType.PREMIUM)
                    .build();

            theaterSeatList.add(theaterSeat);
        }

        theater.setTheaterSeatList(theaterSeatList);
        theaterRespository.save(theater);

        
    }
}
