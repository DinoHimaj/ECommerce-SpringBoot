package com.example.ecommerceapp.API.controller.auth;

import com.example.ecommerceapp.API.RegistrationBody;
import com.example.ecommerceapp.model.dao.LocalUserRepository;
import com.example.ecommerceapp.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService){
        this.userService = userService;
    }

@PostMapping("/register")
    public void registerUser(@RequestBody RegistrationBody registrationBody){
    userService.registerUser(registrationBody);
}
}