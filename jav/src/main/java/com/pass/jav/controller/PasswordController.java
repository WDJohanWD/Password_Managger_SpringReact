package com.pass.jav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pass.jav.domain.AppUsers;
import com.pass.jav.domain.Password;
import com.pass.jav.service.PasswordService;
import com.pass.jav.service.UsersService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public String registrar(@RequestBody AppUsers user) {   
        
        return usersService.guardar(user).toString();
    }

        
    
    @GetMapping("/passwords")
    public String obtenerTodosLosPasswords() {
        return passwordService.obtenerTodosLosPasswords().toString();
    }
    
    @PostMapping("/passwords")
    public String guardarPassword(@RequestBody Password password) {
        return passwordService.guardarPassword(password).toString();
    }

}
