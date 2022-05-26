package com.example.jpa.service;

import java.util.List;

import com.example.jpa.model.filter.ConfiguracionSistemaExternoFilter;
import com.example.jpa.model.request.ConfiguracionSistemaExternoRequest;
import com.example.jpa.model.response.ConfiguracionSistemaExternoResponse;

public interface ConfiguracionSistemaExternoService {
    
    
    public List<ConfiguracionSistemaExternoResponse> buscarTodos();
    
    public ConfiguracionSistemaExternoResponse buscarPorIdConfiguracion(Integer idConfiguracion);
    
	public String buscarPorIdConfiguracionCompleta(Integer idConfiguracion);
    
    public List<ConfiguracionSistemaExternoResponse> buscarPorFiltros(ConfiguracionSistemaExternoFilter configuracionSistemaExternoFilter);
    
    public ConfiguracionSistemaExternoResponse registrarConfiguracion(ConfiguracionSistemaExternoRequest configuracionSistemaExternoRequest);
    
    public ConfiguracionSistemaExternoResponse actualizarConfiguracion(Integer idConfiguracion, ConfiguracionSistemaExternoRequest configuracionSistemaExternoRequest);
	
	public void eliminarConfiguracion(ConfiguracionSistemaExternoRequest configuracionSistemaExternoRequest);

}
