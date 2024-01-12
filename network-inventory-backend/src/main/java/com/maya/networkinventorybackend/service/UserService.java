package com.maya.networkinventorybackend.service;

import com.maya.networkinventorybackend.model.User;
import com.maya.networkinventorybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
     UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }



}
