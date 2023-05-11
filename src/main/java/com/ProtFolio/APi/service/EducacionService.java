
package com.ProtFolio.APi.service;


import com.ProtFolio.APi.model.Educacion;
import com.ProtFolio.APi.repository.EducacionRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    public EducacionRepository eduRepo;

    @Override
    public void agregarEducacion(Educacion educ) {
        eduRepo.save(educ);
    }

    @Override
    public List<Educacion> verEducacion() {
        return eduRepo.findAll();
    }

    @Override
    public void borrarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return eduRepo.findById(id).orElse(null);
    }
    
   
}
