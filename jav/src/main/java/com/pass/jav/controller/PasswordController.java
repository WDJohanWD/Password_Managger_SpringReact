package com.pass.jav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.pass.jav.service.PasswordService;

public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @GetMapping()
    public String obtenerTodosLosPasswords() {
        return passwordService.obtenerTodosLosPasswords().toString();
    }
    
}
