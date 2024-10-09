package com.example.alumnos.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.alumnos.model.Alumnos;

public interface AlumnosRepository extends JpaRepository<Alumnos, Integer>{

}
