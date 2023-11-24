package com.example.BookMyShow.Respository;

import com.example.BookMyShow.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository  extends JpaRepository<User,Integer> {
}
