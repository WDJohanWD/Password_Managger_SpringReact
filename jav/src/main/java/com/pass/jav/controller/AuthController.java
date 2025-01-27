package com.pass.jav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.pass.jav.domain.AppUsers;
import com.pass.jav.dto.ResponseMessage;
import com.pass.jav.service.UsersService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsersService usersService;


    @GetMapping("/login")
    public String login() {
        return usersService.obtenerTodos().toString();

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AppUsers user) {
        String username = user.getUsername();
        String password = user.getPassword();

        if (usersService.comprobarUsuario(username, password)) {
            return ResponseEntity.ok(new ResponseMessage("Login successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Invalid credentials"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody AppUsers user) {
        // NO encriptar aquí
        AppUsers nuevoUsuario = usersService.guardar(user);
        if (nuevoUsuario == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseMessage("Username already exists"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage("User registered successfully"));
    }

}
