package com.isilsoft.Gymis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visitas")
@Data
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String LOCAL;
    @Column(unique = true)
    private String DNIAFILIADO;
    private LocalDate FECHA;
    private LocalTime HORA;
}
