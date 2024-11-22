package com.ftv.appsbjpa.modelo.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

@Entity
@Table(name = "direcciones")
public class DireccionDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dir")
    private Integer id;

    @NotEmpty(message = "La dirección no puede estar vacía")
    @Column(name = "dir_dir")
    private String direccion;

    @NotEmpty(message = "La ciudad no puede estar vacía")
    @Column(name = "ciu_dir")
    private String ciudad;

    @NotEmpty(message = "La región no puede estar vacía")
    @Column(name = "reg_dir")
    private String region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
