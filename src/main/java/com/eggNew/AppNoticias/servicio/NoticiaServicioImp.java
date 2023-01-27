package com.eggNew.AppNoticias.servicio;

import com.eggNew.AppNoticias.exception.MiException;
import com.eggNew.AppNoticias.model.Noticia;
import com.eggNew.AppNoticias.repositorio.noticiaRepositorio;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaServicioImp implements NoticiaServicio{
    
    @Autowired
    private noticiaRepositorio noticiaRepo;

    @Override
    public void guardar(String titulo, String cuerpo) throws MiException {
        
        validar(titulo, cuerpo);
        
        Noticia noticia = new Noticia();
        noticia.setNombre(titulo);
        noticia.setCuerpo(cuerpo);
        noticiaRepo.save(noticia);
        
    }

    @Override
    public List<Noticia> listarNoticias() {
         return noticiaRepo.findAll();
    }

    @Override
    public Noticia buscarPorId(Long id) {

        Noticia noticia = null;
        if (Objects.nonNull(id)) {
            Optional<Noticia> oNoticia = noticiaRepo.findById(id);

            if (oNoticia.isPresent()) {

                noticia = oNoticia.get();
            } else {

                throw new RuntimeException("El Id: " + id + " no existe");
            }

        }
        return noticia;
    }
    
    @Override
    public Noticia getOne(Long id){
        
        return noticiaRepo.getOne(id);    
    }
    
    @Transactional
    @Override
    public void modificarNoticia(Long id, String titulo, String cuerpo) throws MiException{
        
        validar(titulo, cuerpo);
        
         Optional<Noticia> oNoticia = noticiaRepo.findById(id);
         
         if (oNoticia.isPresent()) {

            Noticia noticia = oNoticia.get();
            noticia.setNombre(titulo);
            noticia.setCuerpo(cuerpo);
        
            noticiaRepo.save(noticia);
         }
    }

    @Override
    public void eliminarNoticia(Long id) {
       
        noticiaRepo.deleteById(id);
    }
    
    
   public void validar(String titulo, String cuerpo) throws MiException{
       
       if(titulo.isEmpty() || titulo == null){
           
            throw new MiException("Por favor complete todo los campos");
       
       }
       
       if(cuerpo.isEmpty() || cuerpo == null){
           
            throw new MiException("Por favor complete todo los campos");
       
       }
   
   }
    
}
