package com.ryan.movies.movie_ranker.controller;

import com.ryan.movies.movie_ranker.model.User;
import com.ryan.movies.movie_ranker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.registerUser(user.getUsername(), user.getEmail(), user.getPassword());
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
