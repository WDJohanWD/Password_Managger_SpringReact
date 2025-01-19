package com.pass.jav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pass.jav.domain.Password;
import com.pass.jav.service.PasswordService;

public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @GetMapping()
    public String obtenerTodosLosPasswords() {
        return passwordService.obtenerTodosLosPasswords().toString();
    }
    
    @PostMapping()
    public String guardarPassword(@RequestBody Password password) {
        return passwordService.guardarPassword(password).toString();
    }

}
