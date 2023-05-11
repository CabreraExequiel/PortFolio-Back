
package com.ProtFolio.APi.service;

import com.ProtFolio.APi.model.Empleo;
import com.ProtFolio.APi.repository.EmpleoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleoService implements IEmpleoService {
    
    @Autowired
    public EmpleoRepository emprepo;

    @Override
    public void agregarEmpleo(Empleo emp) {
        emprepo.save(emp);
    }

    @Override
    public List<Empleo> verEmpleo() {
        return emprepo.findAll();
    }

    @Override
    public void borrarEmpleo(Long id) {
        emprepo.deleteById(id);
    }
    
    
    
}
