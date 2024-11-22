package com.ftv.appsbjpa.modelo.repository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByCorreo(String correo);
    List<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
}
