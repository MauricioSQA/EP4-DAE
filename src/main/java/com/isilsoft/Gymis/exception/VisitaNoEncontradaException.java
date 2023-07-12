package com.isilsoft.Gymis.exception;

public class VisitaNoEncontradaException extends RuntimeException{

    public VisitaNoEncontradaException(Long id){
        super(String.format("Visita con id% no existe en la base de datos",id));
    }
}
