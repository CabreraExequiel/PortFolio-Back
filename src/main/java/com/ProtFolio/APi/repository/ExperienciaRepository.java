
package com.ProtFolio.APi.repository;

import com.ProtFolio.APi.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long>{
    
}
