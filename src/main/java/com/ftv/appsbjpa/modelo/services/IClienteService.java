package com.ftv.appsbjpa.modelo.services;

import com.ftv.appsbjpa.modelo.dto.ClienteDTO;
import java.util.List;

public interface IClienteService {
    List<ClienteDTO> listarTodos();
    ClienteDTO buscarPorId(Integer id);
    void guardar(ClienteDTO clienteDTO);
    void eliminar(Integer id);
    List<ClienteDTO> buscarPorNombre(String nombre);
}