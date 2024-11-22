package com.ftv.appsbjpa.modelo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AreaDTO {
    private Integer id;

    @NotEmpty(message = "El nombre del área es requerido")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;
}