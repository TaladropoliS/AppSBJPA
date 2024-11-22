package com.ftv.appsbjpa.modelo.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
@Entity
@Table(name = "areas")
public class AreaDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_are")
    private Integer id;

    @NotEmpty
    @Column(name = "nom_are")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "cli_are")
    private ClienteDTO cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
