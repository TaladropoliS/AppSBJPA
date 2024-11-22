package com.ftv.appsbjpa.modelo.dao;

import com.ftv.appsbjpa.modelo.dto.ClienteDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("ClienteDAO_JPA")
public class ClienteDAO implements IClienteDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ClienteDTO> ListarClientesTodos() {
        return em.createQuery("select c from ClienteDTO c", ClienteDTO.class).getResultList();
    }

    @Override
    public List<ClienteDTO> listarClientesPorCiudad(String ciudad) {
        return em.createQuery("select c from ClienteDTO c where c.direccion.ciudad = :ciudad", ClienteDTO.class)
                .setParameter("ciudad", ciudad)
                .getResultList();
    }

    @Override
    public ClienteDTO buscarClientePorId(Integer id) {
        return em.find(ClienteDTO.class, id);
    }

    @Override
    public void crearCliente(ClienteDTO cliente) {
        if (cliente.getId() == null) {
            em.persist(cliente);
        }
    }

    @Override
    public void editarCliente(ClienteDTO cliente) {
        if (cliente.getId() != null && cliente.getId() > 0) {
            em.merge(cliente);
        }
    }

    @Override
    public void eliminarCliente(Integer id) {
        ClienteDTO c = buscarClientePorId(id);
        em.remove(c);
    }


}