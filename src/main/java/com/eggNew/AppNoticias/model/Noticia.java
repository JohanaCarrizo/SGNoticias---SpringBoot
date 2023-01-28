package com.eggNew.AppNoticias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Noticia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String nombre;
    private String cuerpo;
    
    public String getSubstringDelCuepo(){
        
        if(cuerpo.length()<50){
            
            return cuerpo;        
        }else{
        
            return cuerpo.substring(0, 50).concat("...");
        }
        
        
    
    }
    
}
