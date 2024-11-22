package com.ftv.appsbjpa.modelo.services.impl;

import com.ftv.appsbjpa.modelo.dto.AreaDTO;
import com.ftv.appsbjpa.modelo.entity.Area;
import com.ftv.appsbjpa.modelo.repository.IAreaRepository;
import com.ftv.appsbjpa.modelo.services.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private IAreaRepository areaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AreaDTO> listarTodos() {
        return areaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AreaDTO buscarPorId(Integer id) {
        return areaRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    @Transactional
    public void guardar(AreaDTO areaDTO) {
        Area area = convertToEntity(areaDTO);
        areaRepository.save(area);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        areaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AreaDTO> buscarPorNombre(String nombre) {
        return areaRepository.findByNombreContainingIgnoreCase(nombre).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AreaDTO convertToDTO(Area area) {
        AreaDTO dto = new AreaDTO();
        dto.setId(area.getId());
        dto.setNombre(area.getNombre());
        dto.setDescripcion(area.getDescripcion());
        dto.setActivo(area.isActivo());
        return dto;
    }

    private Area convertToEntity(AreaDTO dto) {
        Area area = new Area();
        area.setId(dto.getId());
        area.setNombre(dto.getNombre());
        area.setDescripcion(dto.getDescripcion());
        area.setActivo(dto.isActivo());
        return area;
    }
}