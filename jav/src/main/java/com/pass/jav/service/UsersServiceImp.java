package com.pass.jav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pass.jav.domain.AppUsers;
import com.pass.jav.repositories.UsersRepository;

@Service
public class UsersServiceImp implements UsersService { 
    
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public AppUsers guardar(AppUsers user) {
        return usersRepository.save(user);
    }

    @Override
    public void borrar(AppUsers user) {
        usersRepository.delete(user);
    }

}
