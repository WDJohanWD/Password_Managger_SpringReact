package com.pass.jav.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pass.jav.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UsersService usersService;

    @GetMapping()
    public String getMethodName() {
        return new String();
    }
    

    @PostMapping("/login")
     public ResponseEntity<?> loginUser(@RequestBody String user, @RequestBody String password) {
        

        if (usersService.comprobarUsuario(user, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
