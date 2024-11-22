package com.ftv.appsbjpa.modelo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String direccion;

    private String ciudad;

    private String region;

    @OneToOne(mappedBy = "direccion")
    private Cliente cliente;
}