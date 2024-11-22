package com.ftv.appsbjpa.modelo.services;

import com.ftv.appsbjpa.modelo.dto.AreaDTO;
import java.util.List;

public interface IAreaService {
    List<AreaDTO> listarTodos();
    AreaDTO buscarPorId(Integer id);
    void guardar(AreaDTO areaDTO);
    void eliminar(Integer id);
    List<AreaDTO> buscarPorNombre(String nombre);
}