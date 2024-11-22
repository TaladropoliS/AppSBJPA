package com.ftv.appsbjpa.modelo.services.impl;

import com.ftv.appsbjpa.modelo.dto.AreaDTO;
import com.ftv.appsbjpa.modelo.dto.ClienteDTO;
import com.ftv.appsbjpa.modelo.services.IAreaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AreaSERVICE_JPA")
public class AreaServiceImpl implements IAreaService {

    @Transactional(readOnly = true)
    @Override
    public List<AreaDTO> ListarTodos() {
        return List.of();
    }

    @Transactional(readOnly = true)
    @Override
    public AreaDTO buscarPorId(Integer id) {
        return null;
    }

    @Transactional
    @Override
    public void crearArea(ClienteDTO area) {

    }

    @Transactional
    @Override
    public void editarArea(ClienteDTO area) {

    }

    @Transactional
    @Override
    public void eliminarArea(Integer id) {

    }
}
