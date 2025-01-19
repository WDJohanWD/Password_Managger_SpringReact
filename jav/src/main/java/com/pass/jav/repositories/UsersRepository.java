package com.pass.jav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pass.jav.domain.AppUsers;


@Repository
public interface UsersRepository extends JpaRepository<AppUsers, Long> {
    
    AppUsers findByUsername(String username);
    
}
