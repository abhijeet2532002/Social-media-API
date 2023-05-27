package com.UserService.service;

import com.UserService.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUserDetails();
    User getUserDetails(String id);
    User saveUserDetails(User user);
}
