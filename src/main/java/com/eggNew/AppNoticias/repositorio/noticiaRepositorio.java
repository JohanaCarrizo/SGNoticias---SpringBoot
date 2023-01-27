package com.eggNew.AppNoticias.repositorio;

import com.eggNew.AppNoticias.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface noticiaRepositorio extends JpaRepository<Noticia, Long> {
    
}
