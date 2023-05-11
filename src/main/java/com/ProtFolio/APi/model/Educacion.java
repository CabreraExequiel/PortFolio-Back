
package com.ProtFolio.APi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre_curso;
    private String titulo;
    private String descripcion;
    private String url_img;
    
    public Educacion(){}
    
    public Educacion(Long id, String nombre_curso, String titulo, String descripcion, String url_img){
        this.id = id;
        this.nombre_curso = nombre_curso;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_img = url_img;
        
    }
    
    
    
}
