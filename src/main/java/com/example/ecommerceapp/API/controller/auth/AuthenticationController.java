package com.example.ecommerceapp.API.controller.auth;

import com.example.ecommerceapp.API.RegistrationBody;
import com.example.ecommerceapp.exception.UserAlreadyExistsException;
import com.example.ecommerceapp.model.dao.LocalUserRepository;
import com.example.ecommerceapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        }catch(UserAlreadyExistsException ex){
            return  ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
