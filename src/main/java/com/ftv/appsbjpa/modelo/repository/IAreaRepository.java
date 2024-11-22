package com.ftv.appsbjpa.modelo.repository;

public interface IAreaRepository extends JpaRepository<Area, Integer> {
    List<Area> findByClienteId(Integer clienteId);

    List<Area> findByNombreContaining(String nombre);
}