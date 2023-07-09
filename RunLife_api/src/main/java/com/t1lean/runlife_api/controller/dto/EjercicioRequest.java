package com.t1lean.runlife_api.controller.dto;

import io.micrometer.common.lang.Nullable;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EjercicioRequest {
    private String nombre;
    private String descripcion;
    private String grupoMuscular;

    @Nullable
    private Long categoriaEjercicioId;
}
