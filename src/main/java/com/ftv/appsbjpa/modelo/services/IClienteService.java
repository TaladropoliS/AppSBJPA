package com.ftv.appsbjpa.modelo.services;

import com.ftv.appsbjpa.modelo.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {

    public List<ClienteDTO> ListarTodos();

    public ClienteDTO buscarPorId(Integer id);

    public void crearCliente(ClienteDTO cliente);

    public void editarCliente(ClienteDTO cliente);

    public void eliminar(Integer id);
}
