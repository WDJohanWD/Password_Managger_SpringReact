package com.pass.jav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pass.jav.domain.Password;
import com.pass.jav.repositories.PasswordRepository;

@Service
public class PasswordServiceImp implements PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;

    public List<Password> obtenerTodosLosPasswords() {
        return passwordRepository.findAll();
    }

    public Password guardarPassword(Password password) {
        return passwordRepository.save(password);
    }
}
