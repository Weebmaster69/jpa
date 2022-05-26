package com.example.jpa.model.response;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="VW_MAN_CONFIGURACION_SIS_EXT")
public class ConfiguracionSistemaExternoResponse implements Serializable {
    @Id
    @Column(name = "ID_CONFIGURACION")
    private Integer idConfiguracion;
    @Column(name = "ID_SISTEMA_EXTERNO")
    private Integer idSistemaExterno;
    @Column(name = "SISTEMA_EXTERNO_DESCRIPCION")
    private String idSistemaExternoDescripcion;
    @Column(name = "VALOR")
    private String valor;
    @Column(name = "TIPO")
    private Integer tipo;
    @Column(name = "TIPO_DESCRIPCION")
    private String tipoDescripcion;
    @Column(name = "ID_CONFIGURACION_PADRE")
    private Integer idConfiguracionPadre;
}
