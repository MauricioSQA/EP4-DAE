package com.isilsoft.Gymis.repository;

import com.isilsoft.Gymis.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsername(String username);


    @Query("SELECT COUNT(v) > 0 FROM Usuario v WHERE v.username = :username")
    boolean existsByUsername(@Param("username") String username);
}
