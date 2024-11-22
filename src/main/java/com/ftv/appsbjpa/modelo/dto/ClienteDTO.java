package com.ftv.appsbjpa.modelo.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ClienteDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private LocalDateTime creado;
    private DireccionDTO direccion;
    private List<AreaDTO> areas;
}

@Data
public class DireccionDTO {
    private Integer id;
    private String direccion;
    private String ciudad;
    private String region;
}

@Data
public class AreaDTO {
    private Integer id;
    private String nombre;
    private Integer clienteId;
}