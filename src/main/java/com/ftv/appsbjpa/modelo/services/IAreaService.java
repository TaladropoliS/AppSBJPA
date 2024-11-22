package com.ftv.appsbjpa.modelo.services;

import com.ftv.appsbjpa.modelo.dto.AreaDTO;
import com.ftv.appsbjpa.modelo.dto.ClienteDTO;

import java.util.List;

public interface IAreaService {

    public List<AreaDTO> ListarTodos();

    public AreaDTO buscarPorId(Integer id);

    public void crearArea(ClienteDTO area);

    public void editarArea(ClienteDTO area);

    public void eliminarArea(Integer id);
}
