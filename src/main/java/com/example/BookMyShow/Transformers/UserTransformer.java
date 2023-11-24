package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.RequestDtos.AddUserRequest;

public class UserTransformer {

    public static User convertAddUserToUserEntity(AddUserRequest addUserRequest){

        User user=User.builder()
                .name(addUserRequest.getName())
                .age(addUserRequest.getAge())
                .emailId(addUserRequest.getEmail())
                .mobNo(addUserRequest.getMobNo())
                .build();

        return user;

    }


}
