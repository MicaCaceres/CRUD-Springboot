package com.example.CrudSpringboot.Model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id;

    @NotBlank(message = "Es necesario ingresar un nombre")
    @Size(min = 3, max = 255, message = "Deben ser más de 2 caracteres")
    @Column(name = "nombre_usuario")
    private String nombre;

    @NotBlank(message = "Es necesario ingresar un usuario")
    @Column(name = "usuario_usuario")
    private String usuario;

    @NotNull(message = "Es necesario ingresar una fecha")
    @Column(name = "nacimiento_usuario")
    private LocalDate nacimiento;

    @NotBlank(message = "Es necesario ingresar una contraseña")
    @Size(min = 8, max = 16, message = "Deben ser al menos 8 caracteres")
    @Column(name = "contraseña_usuario")
    private String contraseña;

    @Email(message = "El correo electrónico debe ser válido")
    @Column(name = "email_usuario")
    private String email;

    @Column(name = "dni_usuario")
    private long dni;
}
