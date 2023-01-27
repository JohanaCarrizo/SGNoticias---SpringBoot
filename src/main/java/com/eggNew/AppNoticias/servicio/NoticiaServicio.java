package com.eggNew.AppNoticias.servicio;

import com.eggNew.AppNoticias.exception.MiException;
import com.eggNew.AppNoticias.model.Noticia;
import java.util.List;

public interface NoticiaServicio {
    
    void guardar(String titulo, String cuerpo) throws MiException;
    
    List<Noticia>listarNoticias();
    
    Noticia buscarPorId(Long id);
    
    Noticia getOne(Long id);

    void modificarNoticia(Long id, String titulo, String cuerpo) throws MiException;
    
    void eliminarNoticia(Long id);
   
}
