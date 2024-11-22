package com.ftv.appsbjpa.controllers;

import com.ftv.appsbjpa.modelo.dto.AreaDTO;
import com.ftv.appsbjpa.modelo.services.IAreaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    @Qualifier("AreaSERVICE_JPA")
    private IAreaService areaService;

    @GetMapping("/listar")
    public String listar(Model model) {

        try {
            model.addAttribute("titulo", "Listado de Areas");
            model.addAttribute("areas", areaService.ListarTodos());
            return "pages/areas/listar";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las áreas: " + e.getMessage());
            return "pages/areas/listar";
        }
    }
    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("titulo", "Nuevo Área");
        model.addAttribute("area", new AreaDTO());
        return "pages/areas/form";
    }
    @GetMapping("/form/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        if (id <= 0 || id == null) {
            return "redirect:/pages/areas/listar";
        }
        AreaDTO area = areaService.buscarPorId(id);

        model.addAttribute("titulo", "Editar Área");
        model.addAttribute("area", area);
        return "pages/areas/form";
    }
    @PostMapping("/form")
    public String guardar(@Valid @ModelAttribute("area") AreaDTO area, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Área");
            return "pages/areas/form";
        }

        try {
            String mensaje;
            if (area.getId() != null && area.getId() > 0) {
                areaService.editarArea(area);
                mensaje = "Área actualizada con éxito";
            } else {
                areaService.crearArea(area);
                mensaje = "Área creada con éxito";
            }
            flash.addFlashAttribute("success", mensaje);
            return REDIRECT_LISTAR;
        } catch (Exception e) {
            flash.addFlashAttribute("error", "Error al guardar el área: " + e.getMessage());
            return REDIRECT_LISTAR;
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes flash) {
        try {
            if (id > 0) {
                areaService.eliminarArea(id);
                flash.addFlashAttribute("success", "Área eliminada con éxito");
            }
            return REDIRECT_LISTAR;
        } catch (Exception e) {
            flash.addFlashAttribute("error", "Error al eliminar el área: " + e.getMessage());
            return REDIRECT_LISTAR;
        }
    }
}
