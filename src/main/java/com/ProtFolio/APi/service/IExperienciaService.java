
package com.ProtFolio.APi.service;

import com.ProtFolio.APi.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    public void agregarExperiencia(Experiencia exp);
    public List<Experiencia> verExperiencia();
    public void borrarExperiencia(Long id);
    public Experiencia buscarExperiencia(Long id);
}
