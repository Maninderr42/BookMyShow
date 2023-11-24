package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.RequestDtos.AddShowRequest;

public class ShowTransfomer {

    public static Show convertshowRequest(AddShowRequest addShowRequest){
        Show show=Show.builder()
                .showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .build();

        return  show;
    }
}
