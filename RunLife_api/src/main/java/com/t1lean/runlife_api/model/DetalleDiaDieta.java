package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DetalleDiaDieta")
public class DetalleDiaDieta implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "dia_dieta_id")
    private DiaDieta diaDieta;

    @Id
    @ManyToOne
    @JoinColumn(name = "alimento_id")
    private Alimento alimento;
}