package com.ftv.appsbjpa.modelo.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Data
public class ClienteDTO {
    private Integer id;

    @NotEmpty(message = "El nombre es obligatorio")
    private String nombre;

    @NotEmpty(message = "El email es obligatorio")
    @Email(message = "El formato del email no es válido")
    private String email;

    private String telefono;
    private boolean activo = true;
}