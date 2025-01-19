package com.pass.jav.service;

import java.util.List;

import com.pass.jav.domain.Password;

public interface PasswordService {

    List<Password> obtenerTodosLosPasswords();

    Password guardarPassword(Password password);
    
    
}
