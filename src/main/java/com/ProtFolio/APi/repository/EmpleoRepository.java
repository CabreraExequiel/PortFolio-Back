
package com.ProtFolio.APi.repository;

import com.ProtFolio.APi.model.Empleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleoRepository extends JpaRepository<Empleo, Long>{
    
}
