package com.eggNew.AppNoticias.controlador;

import com.eggNew.AppNoticias.servicio.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalControlador {
    
    @Autowired
    private NoticiaServicio noticiaServ;
    
    @GetMapping("/")
    public String vistaInicio(Model modelo){
    
        modelo.addAttribute("vistaInicio", noticiaServ.listarNoticias());
        return "Form-vista-usuario.html";
    }
    
}
