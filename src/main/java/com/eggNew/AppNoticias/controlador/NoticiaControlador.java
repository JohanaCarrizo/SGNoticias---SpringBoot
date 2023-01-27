package com.eggNew.AppNoticias.controlador;

import com.eggNew.AppNoticias.model.Noticia;
import com.eggNew.AppNoticias.servicio.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noticia")
public class NoticiaControlador {
    
    @Autowired
    private NoticiaServicio noticiaServ;
    
    @GetMapping("/leer/{id}")
    public String formLeerNoticia(@PathVariable Long id, Model modelo){
    
        modelo.addAttribute("noticia", noticiaServ.buscarPorId(id));
        return "FormVerNoticia.html";
    }
    
        
    @GetMapping("/editar/{id}")
    public String formularioEditarNoticia(@PathVariable(name = "id") Long id, Model modelo){
    
        modelo.addAttribute("noticia", noticiaServ.buscarPorId(id));
        
        return "formulario_editar_noticia";
    }
    
    /*@PostMapping("/editar/{id}")
    public ModelAndView editarNoticia(@PathVariable(name = "id") Long id){
    
        ModelAndView mav = new ModelAndView("formulario_editar_noticia");
        Noticia noticia = noticiaServ.buscarPorId(id);
        mav.addObject("noticia", noticia);
        
        return mav;
    }*/
    
}
