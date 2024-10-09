package com.example.alumnos.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlumnoDTO {

    @NotEmpty(message = "The name is requiered")
    private String name;

    @Size(min = 10, message = "The username required minimum 5 characters")
    @NotEmpty(message = "The username is requiered")
    private String username;

    @NotNull
    @NotEmpty(message = "The email is requiered")
    
    private String email;

    @NotEmpty(message = "The password is requiered")
    private String password;

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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
