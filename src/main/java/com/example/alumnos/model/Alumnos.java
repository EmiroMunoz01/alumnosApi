package com.example.alumnos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "alumnos")

public class Alumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    
    private String name;

    @NotEmpty(message = "The username is requiered")
    @Column(name="username", unique=true)
    private String username;

    @NotNull
    @NotEmpty(message = "The email is requiered")
    @Column(name="email", unique=true)
    private String email;

    @NotNull
    private String password;

    public Alumnos() {
    }

    public Alumnos(int id, String email, String name, String username, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
