
package com.ProtFolio.APi.service;

import com.ProtFolio.APi.model.Experiencia;
import com.ProtFolio.APi.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{

    @Autowired
    public ExperienciaRepository expRepo;
    
    @Override
    public void agregarExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public List<Experiencia> verExperiencia() {
        return expRepo.findAll();
    }

    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return expRepo.findById(id).orElse(null);
    }
    
}
