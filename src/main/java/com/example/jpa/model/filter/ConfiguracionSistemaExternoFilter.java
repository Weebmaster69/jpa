package com.example.jpa.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfiguracionSistemaExternoFilter {
    
    private Integer idConfiguracion;
    private Integer idSistemaExterno;
    private String valor;
    private Integer tipo;
    private Integer idConfiguracionPadre;
}
