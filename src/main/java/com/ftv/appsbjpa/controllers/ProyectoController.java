package com.ftv.appsbjpa.controllers;

import com.ftv.appsbjpa.modelo.dto.AreaDTO;
import com.ftv.appsbjpa.modelo.dto.ClienteDTO;
import com.ftv.appsbjpa.modelo.dto.DireccionDTO;
import com.ftv.appsbjpa.modelo.services.IProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProyectoController {

    @Autowired
    @Qualifier("ClienteSERVICE_JPA")
    private IProyectoService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("titulo", "Incio");
        return "index";
    }

    @GetMapping("/clientes/listar")
    public String listar(Model model) {
        try {
            model.addAttribute("titulo", "Listado de Clientes");
            model.addAttribute("clientes", clienteService.ListarClientesTodos());
            return "clientes/listar";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los clientes: " + e.getMessage());
            return "clientes/listar";
        } finally {
        }
    }

    @GetMapping("/clientes/formulario/{id}")
    public String editar(@PathVariable(value = "id") Integer id, Model model) {
        ClienteDTO cliente = null;
        if (id > 0) {
            cliente = clienteService.buscarClientePorId(id);
        } else {
            return "redirect:/clientes/listar";
        }
        model.addAttribute("titulo", "Editar Cliente");
        model.addAttribute("cliente", cliente);
        return "clientes/form";
    }

    @GetMapping("/clientes/formulario")
    public String agregarGet(Model model) {
        model.addAttribute("titulo", "Formulario de Cliente");
        ClienteDTO c = new ClienteDTO();
        c.setDireccion(new DireccionDTO());
        List<AreaDTO> areas = new ArrayList<>();
        model.addAttribute("cliente", c);
        model.addAttribute("areas", areas);
        return "clientes/form";
    }

    @PostMapping("/clientes/formulario")
    public String agregarPost(@Valid @ModelAttribute("cliente") ClienteDTO cliente, BindingResult resultado, Model model) {
        if (resultado.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Cliente");
            return "clientes/form";
        }
        try {
            if (cliente.getId() != null && cliente.getId() > 0) {
                clienteService.editarCliente(cliente);
            } else {
                clienteService.crearCliente(cliente);
            }

            return "redirect:/clientes/listar";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el cliente");
            return "clientes/form";
        }
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Integer id) {
        if (id > 0) {
            clienteService.eliminarCliente(id);
        }
        return "redirect:/clientes/listar";
    }

    @GetMapping("/clientes/ciudades")
    public String listarCiudades(Model model) {
        model.addAttribute("titulo", "Listado de Ciudades");
        model.addAttribute("ciudades", clienteService.listarCiudadesTodasUnicas());
        return "clientes/listarCiudades";
    }
}