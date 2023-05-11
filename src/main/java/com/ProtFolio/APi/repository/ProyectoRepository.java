
package com.ProtFolio.APi.repository;

import com.ProtFolio.APi.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
    
}
