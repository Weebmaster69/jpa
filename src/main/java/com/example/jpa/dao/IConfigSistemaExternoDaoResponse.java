package com.example.jpa.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.example.jpa.model.filter.ConfiguracionSistemaExternoFilter;
import com.example.jpa.model.response.ConfiguracionSistemaExternoResponse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface IConfigSistemaExternoDaoResponse extends ReadOnlyRepository<ConfiguracionSistemaExternoResponse, Integer>  {
    @Query(
        value="SELECT vw from ConfiguracionSistemaExternoResponse vw WHERE "
        +"(:#{#filter.idConfiguracion} is null OR vw.idConfiguracion = :#{#filter.idConfiguracion}) "
        +"AND (:#{#filter.idSistemaExterno} is null OR vw.idSistemaExterno = :#{#filter.idSistemaExterno}) "
        +"AND (:#{#filter.valor} is null OR vw.valor = :#{#filter.valor}) "
        +"AND (:#{#filter.tipo} is null OR vw.tipo = :#{#filter.tipo}) "
        )
    public List<ConfiguracionSistemaExternoResponse> buscarPorFiltros(@Param("filter") ConfiguracionSistemaExternoFilter filter);
    public ConfiguracionSistemaExternoResponse findByIdConfiguracion(Integer idConfiguracion);
}
