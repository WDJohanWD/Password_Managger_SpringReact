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
        
        AppUsers existingUser = usersRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            return null; 
        }

       
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println("Hash generado para la contraseña: " + encryptedPassword);

        user.setPassword(encryptedPassword);
        return usersRepository.save(user);
    }


    @Override
    public boolean comprobarUsuario(String username, String password) {
        AppUsers user = usersRepository.findByUsername(username);
        if (user == null) {
            return false; 
        }

        String storedHash = user.getPassword().trim(); 
        boolean matches = passwordEncoder.matches(password.trim(), storedHash.trim());
        System.out.println("Contraseña almacenada (hash): " + storedHash);
        System.out.println("¿Contraseña coincide?: " + matches);
        return matches;
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
    public List<AppUsers> obtenerTodos() {
        return usersRepository.findAll();
    }
}
