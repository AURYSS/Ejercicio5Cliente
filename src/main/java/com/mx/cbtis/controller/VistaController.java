package com.mx.cbtis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.cbtis.modelo.Proyectos;
import com.mx.cbtis.modelo.Tareas;
import com.mx.cbtis.modelo.Usuario;

@Controller
public class VistaController {

    @GetMapping("/home-view")
    public String getHome() {
        return "home";
    }

    @GetMapping("/tutorial-view")
    public String getTutorial() {
        return "tutorial";
    }

    @GetMapping("/manual-view")
    public String getManual() {
        return "manual";
    }

    @GetMapping("/login-view")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register-view")
    public String getRegister(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "register";
    }

    @GetMapping("/inicio-view")
    public String getInicio(Model modelo) {
        Proyectos proyectos = new Proyectos();
        modelo.addAttribute("proyectos", proyectos);
        return "inicio";
    }

    @GetMapping("/tarea-view")
    public String getTarea(Model modelo) {
        Tareas tareas = new Tareas();
        modelo.addAttribute("tareas", tareas);
        return "proyecto";
    }
}
