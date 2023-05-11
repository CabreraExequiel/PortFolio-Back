
package com.ProtFolio.APi.service;

import com.ProtFolio.APi.model.Empleo;
import java.util.List;


public interface IEmpleoService {
    public void agregarEmpleo(Empleo emp);
    public List<Empleo> verEmpleo();
    public void borrarEmpleo(Long id);
}
