
package com.ProtFolio.APi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String descripcion;
    private String url_img;
    
    public Proyecto(){}
    
    public Proyecto(Long id, String nombre, String descripcion, String url_img){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url_img = url_img;
    }
    
}
