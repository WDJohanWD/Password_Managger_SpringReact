package com.pass.jav.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pass.jav.domain.AppUsers;
import com.pass.jav.dto.LoginRequestDTO;
import com.pass.jav.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/login")
    public String getMethodName() {
        return usersService.obtenerTodos().toString();
    }
    

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AppUsers user) {
        String username = user.getUsername();
        String password = user.getEncryptedPassword();
    
        if (usersService.comprobarUsuario(username, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    
}
