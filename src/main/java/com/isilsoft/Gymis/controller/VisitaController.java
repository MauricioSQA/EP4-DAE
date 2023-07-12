package com.isilsoft.Gymis.controller;

import com.isilsoft.Gymis.entity.Visita;
import com.isilsoft.Gymis.service.VisitaService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@AllArgsConstructor
@Controller
@RequestMapping("/visita")
public class VisitaController {

    private final VisitaService visitaService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("Visitas",visitaService.obtenerTodos());
        return "visita/index";
    }

    @GetMapping("/editar")
    public String actualizar(@RequestParam("ID") Long ID, @RequestParam(value = "error", required = false) String error,Model model)throws Exception{
        model.addAttribute("visita",visitaService.obtenerPorId(ID));
        model.addAttribute("error",error);
        return"visita/editar";
    }

    @PostMapping("")
    public String guardar(@ModelAttribute("visita")Visita visita, RedirectAttributes redirectAttributes){
        try {
            visitaService.guardar(visita);
            redirectAttributes.addFlashAttribute("successMessage","Visita creada exitosamente");
        }catch(IllegalArgumentException e){
            redirectAttributes.addFlashAttribute("errorMessage",e.getMessage());
            return "redirect:/visita?error";
        }
        return"redirect:/visita";
    }
    @PutMapping("")
    public String actualizar(@ModelAttribute("visita")Visita visita,RedirectAttributes redirectAttributes){
        try {
            visitaService.guardar(visita);
            redirectAttributes.addFlashAttribute("successMessage","Visita creada exitosamente");
        }catch(IllegalArgumentException e){
            redirectAttributes.addFlashAttribute("errorMessage",e.getMessage());
            return "redirect:/visita/editar?error&ID=" + visita.getID();

        }
        return"redirect:/visita";

    }
    @DeleteMapping("/{ID}")
    public String eliminar(@PathVariable("ID")Long ID){
        visitaService.eliminar(ID);
        return"redirect:/visita";
    }



}
