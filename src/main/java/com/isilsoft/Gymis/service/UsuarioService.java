package com.isilsoft.Gymis.service;

import com.isilsoft.Gymis.entity.Usuario;
import com.isilsoft.Gymis.entity.Visita;
import com.isilsoft.Gymis.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario guardar(Usuario usuario) {
        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
        throw new IllegalArgumentException("El Username ya está registrado");
    }

        return usuarioRepository.save(usuario);}



}
