package com.ftv.appsbjpa.modelo.services;

import com.ftv.appsbjpa.modelo.dao.IClienteDAO;
import com.ftv.appsbjpa.modelo.dao.IDireccionDAO;
import com.ftv.appsbjpa.modelo.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ClienteSERVICE_JPA")
public class ProyectoService implements IProyectoService {

    @Autowired
    private IClienteDAO clienteDAO;

    @Autowired
    private IDireccionDAO direccionDAO;

    @Transactional(readOnly = true)
    @Override
    public List<ClienteDTO> ListarClientesTodos() {
        return clienteDAO.ListarClientesTodos();
    }

    @Override
    public List<ClienteDTO> ListarClientesPorCiudad(String ciudad) {
        return clienteDAO.listarClientesPorCiudad(ciudad);
    }

    @Transactional(readOnly = true)
    @Override
    public ClienteDTO buscarClientePorId(Integer id) {
        return clienteDAO.buscarClientePorId(id);
    }

    @Transactional
    @Override
    public void crearCliente(ClienteDTO cliente) {
        clienteDAO.crearCliente(cliente);
    }

    @Transactional
    @Override
    public void editarCliente(ClienteDTO cliente) {
        clienteDAO.editarCliente(cliente);
    }

    @Transactional
    @Override
    public void eliminarCliente(Integer id) {
        clienteDAO.eliminarCliente(id);
    }

    @Override
    public List<String> listarCiudadesTodasUnicas() {
        return direccionDAO.listarCiudadesTodasUnicas();
    }
}
