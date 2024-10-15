package com.example.alumnos.service;

import org.springframework.stereotype.Service;

import com.example.alumnos.model.AlumnoDTO;
import java.util.*;

@Service
public interface IAlumnoService {

    List<AlumnoDTO> findAll();
    Optional<AlumnoDTO> findByUsername(String username);

}
