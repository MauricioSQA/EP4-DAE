package com.isilsoft.Gymis.controller;

import com.isilsoft.Gymis.entity.Usuario;
import com.isilsoft.Gymis.repository.UsuarioRepository;
import com.isilsoft.Gymis.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@AllArgsConstructor
@Controller
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private  final UsuarioService usuarioService;

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/signup")
    public String showSignUpForm(){
        return "signup";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username")String username,@RequestParam("password") String password){
        Usuario usuario= usuarioRepository.findByUsername(username);
        if(usuario!= null && usuario.getPassword().equals(password)){
            return "redirect:/visita";
        }else{
            return "redirect:/login?error";
        }
    }

    @PostMapping("/signup")
    public String guardar(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirectAttributes){
        try {
            usuarioService.guardar(usuario);
            redirectAttributes.addFlashAttribute("successMessage","Visita creada exitosamente");
        }catch(IllegalArgumentException e){
            redirectAttributes.addFlashAttribute("errorMessage",e.getMessage());
            return "redirect:/signup?error";
        }
        return"redirect:/login";
    }
}
