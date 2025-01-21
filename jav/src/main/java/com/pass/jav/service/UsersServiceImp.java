package com.pass.jav.service;

import java.util.Optional;

import java.util.List;
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
        List<AppUsers> users = usersRepository.findAll();
        for (AppUsers u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                return null;
            }
        }
        return usersRepository.save(user);
    }

    @Override
    public void borrar(AppUsers user) {
        usersRepository.delete(user);
    }

    @Override
    public Optional <AppUsers> buscarPorNombre(String nombre) {
        Optional <AppUsers> user = Optional.ofNullable(usersRepository.findByUsername(nombre));
        return user;
    }

    @Override
    public boolean comprobarUsuario(String nombre, String password) {
        Optional <AppUsers> user = Optional.ofNullable(usersRepository.findByUsername(nombre));
        if (user.isPresent() && user.get().getEncryptedPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<AppUsers> obtenerTodos(){
        return usersRepository.findAll();
    }

   
}
