package com.isilsoft.Gymis.service;

import com.isilsoft.Gymis.entity.Visita;
import com.isilsoft.Gymis.exception.VisitaNoEncontradaException;
import com.isilsoft.Gymis.repository.VisitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VisitaService {

    private  final VisitaRepository visitaRepository;

    public List<Visita>obtenerTodos(){return visitaRepository.findAll();}

    public Visita obtenerPorId(Long ID)throws Exception{
        return visitaRepository.findById(ID)
                .orElseThrow(()-> new VisitaNoEncontradaException(ID));
    }

    public Visita guardar(Visita visita){
        if (visitaRepository.existsByDniAfiliado(visita.getDNIAFILIADO())) {
            throw new IllegalArgumentException("El DNI ya está registrado");
        }

        return visitaRepository.save(visita);}

    public void eliminar(Long ID){
        visitaRepository.delete(visitaRepository.findById(ID).orElseThrow(
                ()-> new VisitaNoEncontradaException(ID)
        ));
    }
}
