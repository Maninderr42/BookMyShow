package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.RequestDtos.AddUserRequest;
import com.example.BookMyShow.Respository.UserRespository;
import com.example.BookMyShow.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;
    public String addUser(AddUserRequest addUserRequest){


        User user= UserTransformer.convertAddUserToUserEntity(addUserRequest);

        userRespository.save(user);

        Collections.sort(new ArrayList<Integer>());

        return "User SuccessFully Added to the DB..........";


    }
}
