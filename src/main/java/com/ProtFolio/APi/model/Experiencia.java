
package com.ProtFolio.APi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String empresa;
    private String descripcion;
    private String url_img;
    
    
    
    public Experiencia(){}
    
    public Experiencia(Long id, String nombre, String empresa, String descripcion, String url_img){
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        this.descripcion = descripcion;
        this.url_img = url_img;
    }
    
}
