package com.example.alumnos.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Alumnos>> getAll() {
        // return repository.findAll();
        return ResponseEntity.ok(repository.findAll());
    }

    // Crear Alumno
    @PostMapping("/crear")
    public ResponseEntity<?> crearAlumnos(
            @RequestBody AlumnoDTO alumnoDTO) {

        try {
            Alumnos alumno = new Alumnos();
            alumno.setName(alumnoDTO.getName());
            alumno.setEmail(alumnoDTO.getEmail());
            alumno.setPassword(alumnoDTO.getPassword());
            alumno.setUsername(alumnoDTO.getUsername());
            // return repository.save(alumno);
            return ResponseEntity.ok(repository.save(alumno));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al intentar crear un cliente");
        }

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

    // Buscar Alumno por username
    @GetMapping("/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username) {

        // Alumnos appAlumnos = repository.findByUsername(username).get();
        // if (appAlumnos == findByUsername(username)) {
        // return ResponseEntity.ok(repository.findByUsername(username));
        // } else {
        // return ResponseEntity.status(HttpStatus.NOT_FOUND)
        // .body("Cliente no encontrado por el username: " + username);
        // }
        try {
            Alumnos alumno = repository.findByUsername(username).get();
            return ResponseEntity.ok(repository.findByUsername(username));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Alumno no encontrado por el username: " + username);
        }
    }

}