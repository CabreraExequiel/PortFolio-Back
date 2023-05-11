
package com.ProtFolio.APi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Empleo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String empresa;
    private String puesto;
    private String año;
    private String ubicacion;
    private String contacto;
    private String url_img;
    
    public Empleo(){}
    
    public Empleo(Long id, String empresa, String puesto, String año, String ubicacion, String contacto, String url_img){
        this.id = id;
        this.empresa = empresa;
        this.puesto = puesto;
        this.año = año;
        this.ubicacion = ubicacion;
        this.contacto = contacto;
        this.url_img = url_img;
    }
    
}
