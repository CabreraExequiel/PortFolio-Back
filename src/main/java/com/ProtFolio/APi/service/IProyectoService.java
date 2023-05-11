
package com.ProtFolio.APi.service;

import com.ProtFolio.APi.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    public void agregarProyecto(Proyecto pro);
    public List<Proyecto> verProyecto();
    public void borrarProyecto(Long id);
    public Proyecto buscarProyecto(Long id);
}
