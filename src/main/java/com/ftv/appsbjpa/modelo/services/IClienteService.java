package com.ftv.appsbjpa.modelo.services;

public interface IClienteService {
    List<ClienteDTO> listarTodos();
    ClienteDTO buscarPorId(Integer id);
    ClienteDTO guardar(ClienteDTO clienteDTO);
    void eliminar(Integer id);
    ClienteDTO actualizarDireccion(Integer clienteId, DireccionDTO direccionDTO);
    ClienteDTO agregarArea(Integer clienteId, AreaDTO areaDTO);
}

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IDireccionRepository direccionRepository;

    @Autowired
    private IAreaRepository areaRepository;

    @Override
    @Transactional
    public ClienteDTO guardar(ClienteDTO clienteDTO) {
        Cliente cliente = convertToEntity(clienteDTO);

        if (clienteDTO.getDireccion() != null) {
            Direccion direccion = convertToDireccionEntity(clienteDTO.getDireccion());
            cliente.setDireccion(direccion);
        }

        cliente = clienteRepository.save(cliente);
        return convertToDTO(cliente);
    }

    @Override
    @Transactional
    public ClienteDTO actualizarDireccion(Integer clienteId, DireccionDTO direccionDTO) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        Direccion direccion = convertToDireccionEntity(direccionDTO);
        cliente.setDireccion(direccion);

        cliente = clienteRepository.save(cliente);
        return convertToDTO(cliente);
    }

    @Override
    @Transactional
    public ClienteDTO agregarArea(Integer clienteId, AreaDTO areaDTO) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        Area area = convertToAreaEntity(areaDTO);
        area.setCliente(cliente);
        cliente.getAreas().add(area);

        cliente = clienteRepository.save(cliente);
        return convertToDTO(cliente);
    }

    // Métodos de conversión Entity <-> DTO
    private ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setCorreo(cliente.getCorreo());
        dto.setCreado(cliente.getCreado());

        if (cliente.getDireccion() != null) {
            dto.setDireccion(convertToDireccionDTO(cliente.getDireccion()));
        }

        dto.setAreas(cliente.getAreas().stream()
                .map(this::convertToAreaDTO)
                .collect(Collectors.toList()));

        return dto;
    }

    // Otros métodos de conversión...
}