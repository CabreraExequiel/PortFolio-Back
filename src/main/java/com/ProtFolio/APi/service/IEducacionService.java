
package com.ProtFolio.APi.service;

import com.ProtFolio.APi.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
    public void agregarEducacion(Educacion Educ);
    public List<Educacion> verEducacion();
    public void borrarEducacion(Long id);
    public Educacion buscarEducacion(Long id);
    
}
