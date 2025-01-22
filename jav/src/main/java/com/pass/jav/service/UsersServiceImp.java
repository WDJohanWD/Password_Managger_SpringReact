package com.pass.jav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pass.jav.domain.AppUsers;
import com.pass.jav.repositories.UsersRepository;

import java.util.Optional;
import java.util.List;

@Service
public class UsersServiceImp implements UsersService { 
    
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Esto será inyectado desde el bean

    @Override
    public AppUsers guardar(AppUsers user) {
        // Verificar si el usuario ya existe
        AppUsers existingUser = usersRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            return null;  // El usuario ya existe
        }
        
        // Encriptar la contraseña antes de guardar
        String encryptedPassword = passwordEncoder.encode(user.getEncryptedPassword());
        user.setEncryptedPassword(encryptedPassword);
        return usersRepository.save(user);
    }

    @Override
    public boolean comprobarUsuario(String username, String password) {
        AppUsers user = usersRepository.findByUsername(username);
        if (user == null) {
            return false;  // Usuario no encontrado
        }
        return passwordEncoder.matches(password, user.getEncryptedPassword());
    }

    @Override
    public void borrar(AppUsers user) {
        usersRepository.delete(user);
    }

    @Override
    public Optional<AppUsers> buscarPorNombre(String nombre) {
        return Optional.ofNullable(usersRepository.findByUsername(nombre));
    }

    @Override
    public List<AppUsers> obtenerTodos(){
        return usersRepository.findAll();
    }
}
