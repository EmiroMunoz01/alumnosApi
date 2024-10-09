package com.example.alumnos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.alumnos.model.AlumnoDTO;
import com.example.alumnos.model.Alumnos;
import com.example.alumnos.service.AlumnosRepository;

@RestController
@RequestMapping("/alumno")
public class AlumnoControlador {

    @Autowired
    private AlumnosRepository repository;

    // Obtener alumno
    @GetMapping({ "", "/" })
    public List<Alumnos> getAll() {
        return repository.findAll();
    }

    // Crear Alumno
    @PostMapping("/crear")
    public Alumnos crearAlumnos(
            @RequestBody AlumnoDTO alumnoDTO) {

        Alumnos alumno = new Alumnos();
        alumno.setName(alumnoDTO.getName());
        alumno.setEmail(alumnoDTO.getEmail());
        alumno.setPassword(alumnoDTO.getPassword());
        alumno.setUsername(alumnoDTO.getUsername());
        return repository.save(alumno);

    }

    // Eliminar Alumno por ID
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable int id) {
        try {
            Alumnos alumno = repository.findById(id).get();
            repository.delete(alumno);

        } catch (Exception ex) {
            System.out.println("Excepcion " + ex.getMessage());
        }
    }

    // Buscar Alumno por ID
    @GetMapping("/{id}")
    public Optional<Alumnos> findById(@PathVariable Integer id) {
        return repository.findById(id);
    }

}
