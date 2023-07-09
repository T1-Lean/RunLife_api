package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DetalleDiaEntrenamiento")
public class DetalleDiaEntrenamiento implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "dia_entrenamiento_id")
    private DiaEntrenamiento diaEntrenamiento;

    @Id
    @ManyToOne
    @JoinColumn(name = "ejercicio_id")
    private Ejercicio ejercicio;
}