package com.isilsoft.Gymis.repository;

import com.isilsoft.Gymis.entity.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepository extends JpaRepository<Visita,Long> {
        @Query("SELECT COUNT(v) > 0 FROM Visita v WHERE v.DNIAFILIADO = :DNIAFILIADO")
        boolean existsByDniAfiliado(@Param("DNIAFILIADO") String DNIAFILIADO);
    }


