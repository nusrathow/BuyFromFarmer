package com.jwt.implementation.controller;
import com.jwt.implementation.model.User;
import com.jwt.implementation.repository.RoleRepository;
import com.jwt.implementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @PostMapping
    public User saveUserWithRole(@RequestBody User user){
        return userRepository.save(user);
    }


    @GetMapping
    public List<User> findAllUser(){
        return userRepository.findAll();
    }
}
