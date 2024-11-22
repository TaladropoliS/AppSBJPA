package com.ftv.appsbjpa.modelo.services;

import com.ftv.appsbjpa.modelo.dto.ClienteDTO;

import java.util.List;

public interface IProyectoService {

    // ClienteDAO
    public List<ClienteDTO> ListarClientesTodos();

    public List<ClienteDTO> ListarClientesPorCiudad(String ciudad);

    public ClienteDTO buscarClientePorId(Integer id);

    public void crearCliente(ClienteDTO cliente);

    public void editarCliente(ClienteDTO cliente);

    public void eliminarCliente(Integer id);

    // DireccionDAO
    public List<String> listarCiudadesTodasUnicas();
}
