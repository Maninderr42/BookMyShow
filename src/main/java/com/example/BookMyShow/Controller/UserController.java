package com.example.BookMyShow.Controller;


import com.example.BookMyShow.RequestDtos.AddUserRequest;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity adduser(@RequestBody AddUserRequest addUserRequest){
        try{
            String res=userService.addUser(addUserRequest);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
