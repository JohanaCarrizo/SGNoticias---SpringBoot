package com.eggNew.AppNoticias.controlador;

import com.eggNew.AppNoticias.exception.MiException;
import com.eggNew.AppNoticias.model.Noticia;
import com.eggNew.AppNoticias.servicio.NoticiaServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/panelAdmin")
public class PanelAdminControlador {
    
    @Autowired
    private NoticiaServicio noticiaServ;
    
    @GetMapping("/gestionar")
    public String formPanelAdmin(Model modelo){
        
        modelo.addAttribute("listar", noticiaServ.listarNoticias());
    
        return "Form-vista-admin.html";
    }
    
    @GetMapping("/agregar")
    public String agregarNoticia(){
    
        return "FormCrearNoticia.html";
    }
    
    @PostMapping("/guardar")
    public String guardarNoticia(@RequestParam String titulo, @RequestParam String cuerpo, ModelMap modelo){
    
        try {
            
            noticiaServ.guardar(titulo, cuerpo);
            modelo.put("exito", "La noticia se creo correctamente!!");
            
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());
            return "FormCrearNoticia.html";
        }
        
        return "redirect:/panelAdmin/gestionar";
    }
    
    @GetMapping("/modificar/{id}")
    public String formModificarNoticia(@PathVariable Long id, ModelMap modelo){
        
        modelo.put("noticia", noticiaServ.getOne(id));
        return "FormModNoticia.html";
    
    }
    
    @PostMapping("/modificarNoticia/{id}")
    public String modificarNoticia(@PathVariable Long id, String titulo, String cuerpo, ModelMap modelo){
        
        try {
            
            noticiaServ.modificarNoticia(id, titulo, cuerpo);
            modelo.put("exito", "La noticia se modifico correctamente!!");
            
            
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "FormModNoticia.html";
        }
    
        return "redirect:/panelAdmin/gestionar";
    }
    
    
    @GetMapping("/eliminar/{id}")
    public String eliminarNoticia(@PathVariable Long id){
        
        noticiaServ.eliminarNoticia(id);
        return "redirect:/panelAdmin/gestionar";
    
    }
    
}
