
package com.ProtFolio.APi.service;

import com.ProtFolio.APi.model.Proyecto;
import com.ProtFolio.APi.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public ProyectoRepository proRepo;
    
    @Override
    public void agregarProyecto(Proyecto pro) {
        proRepo.save(pro);
    }

    @Override
    public List<Proyecto> verProyecto() {
        return proRepo.findAll();
    }

    @Override
    public void borrarProyecto(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proRepo.findById(id).orElse(null);
    }
    
}
