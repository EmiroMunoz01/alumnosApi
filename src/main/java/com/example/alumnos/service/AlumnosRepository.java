package com.example.alumnos.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import com.example.alumnos.model.Alumnos;



public interface AlumnosRepository extends JpaRepository<Alumnos, Integer>{
    
    @Transactional(readOnly = true)
    Optional<Alumnos> findByUsername(String username);
    
}
