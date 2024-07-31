package com.redisexample.redis_example.controller;

import com.redisexample.redis_example.model.User;
import com.redisexample.redis_example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user/create")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        boolean result = userService.saveUser(user);
        if(result)
            return ResponseEntity.ok("User Created Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<Object>> fetchAllUser() {
        List<Object> users;
        users = userService.fetchAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity fetchUserById(@PathVariable("id") Long id) {
        User userByService;
        userByService = userService.fetchUserById(id);
        return ResponseEntity.ok(userByService);
    }
}
