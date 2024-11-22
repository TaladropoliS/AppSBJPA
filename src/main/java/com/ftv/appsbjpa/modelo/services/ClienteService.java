package com.ftv.appsbjpa.modelo.services;

import com.ftv.appsbjpa.modelo.dao.ClienteDAO;
import com.ftv.appsbjpa.modelo.dao.IClienteDAO;
import com.ftv.appsbjpa.modelo.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ClienteSERVICE_JPA")
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteDAO clienteDAO;

    @Transactional(readOnly = true)
    @Override
    public List<ClienteDTO> ListarTodos() {
        return clienteDAO.ListarTodos();
    }

    @Transactional(readOnly = true)
    @Override
    public ClienteDTO buscarPorId(Integer id) {
        return clienteDAO.buscarPorId(id);
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
    public void eliminar(Integer id) {
        clienteDAO.eliminar(id);
    }
}
