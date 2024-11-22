package com.ftv.appsbjpa.modelo.repository;

import com.ftv.appsbjpa.modelo.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAreaRepository extends JpaRepository<Area, Integer> {
    List<Area> findByNombreContainingIgnoreCase(String nombre);
    List<Area> findByActivoTrue();
}