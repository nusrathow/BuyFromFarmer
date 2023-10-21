/*
package com.jwt.implementation.controller;


import com.jwt.implementation.dto.UserRegisteredDTO;
import com.jwt.implementation.model.Category;
import com.jwt.implementation.service.DefaultUserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private DefaultUserService userService;

    public RegistrationController(DefaultUserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegisteredDTO userRegistrationDto() {
        return new UserRegisteredDTO();
    }

    @GetMapping
    public void showRegistrationForm() {
        System.out.println("....");
    }

    @PostMapping
    public void registerUserAccount(@ModelAttribute("user")
                                      UserRegisteredDTO registrationDto) {
        userService.save(registrationDto);
        System.out.println("....register");
    }

    */
/*@RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void createNewCategory(@RequestBody UserRegisteredDTO registrationDto) throws URISyntaxException {
        userService.save(registrationDto);
        System.out.println("....register");
    }*//*

}
*/
