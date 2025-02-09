package com.pass.jav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pass.jav.domain.Password;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {

}
