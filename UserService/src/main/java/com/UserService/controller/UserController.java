package com.UserService.controller;

import com.UserService.entity.User;
import com.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAllUserDetails() {
        return service.getAllUserDetails();
    }

    @GetMapping("/{id}")
    public User getUserDetails(@PathVariable String id) {
        return service.getUserDetails(id);
    }

    @PostMapping
    public User saveUserDetails(@RequestBody User user) {
        return service.saveUserDetails(user);
    }
}
