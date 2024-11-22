package com.ftv.appsbjpa.modelo.repository;

public interface IDireccionRepository extends JpaRepository<Direccion, Integer> {
    List<Direccion> findByCiudad(String ciudad);
}
