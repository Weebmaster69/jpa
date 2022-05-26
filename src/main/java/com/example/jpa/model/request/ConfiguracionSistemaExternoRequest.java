package com.example.jpa.model.request;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name="MAE_CONFIG_SIS_EXT")
public class ConfiguracionSistemaExternoRequest implements Serializable {
    @Id
    @SequenceGenerator(name="seq_config", sequenceName="SEQ_MAE_CONFIG_SIS_EXT", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_config")   
    @Column(name = "ID_CONFIGURACION")
    private Integer idConfiguracion;

    @Column(name = "ID_SISTEMA_EXTERNO")
    private Integer idSistemaExterno;
    @Column(name = "VALOR")
    private String valor;
    @Column(name = "TIPO")
    private Integer tipo;
    @Column(name = "ID_CONFIGURACION_PADRE")
    private Integer idConfiguracionPadre;
    @Column(name = "USUARIO_ADICION")
    private String usuario;
}
