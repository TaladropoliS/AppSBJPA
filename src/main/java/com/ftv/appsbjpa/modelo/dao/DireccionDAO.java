package com.ftv.appsbjpa.modelo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DireccionDAO_JPA")
public class DireccionDAO implements IDireccionDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<String> listarCiudadesTodasUnicas() {
        return em.createQuery("select distinct d.ciudad from DireccionDTO d", String.class).getResultList();
    }
}
