package com.pass.jav.service;

import java.util.List;
import java.util.Optional;

import com.pass.jav.domain.AppUsers;

public interface UsersService {


    AppUsers guardar(AppUsers user);


    void borrar(AppUsers user);

    Optional <AppUsers> buscarPorNombre(String nombre);

    boolean comprobarUsuario(String nombre, String password);

    List<AppUsers> obtenerTodos();


    
    

    
}
