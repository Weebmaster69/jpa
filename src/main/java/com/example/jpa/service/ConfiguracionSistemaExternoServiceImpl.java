package com.example.jpa.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.jpa.dao.IConfigSistemaExternoDaoResponse;
import com.example.jpa.dao.IConfiguracionSistemaExternoDao;
import com.example.jpa.model.filter.ConfiguracionSistemaExternoFilter;
import com.example.jpa.model.request.ConfiguracionSistemaExternoRequest;
import com.example.jpa.model.response.ConfiguracionSistemaExternoResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ConfiguracionSistemaExternoServiceImpl implements ConfiguracionSistemaExternoService {

    @Autowired
    private IConfiguracionSistemaExternoDao configuracionSistemaExternoDao;
    @Autowired
    private IConfigSistemaExternoDaoResponse configSistemaExternoDaoResponse;
    
    @Override
    public List<ConfiguracionSistemaExternoResponse> buscarTodos() {
        return configSistemaExternoDaoResponse.findAll();
    }
    @Override
    public ConfiguracionSistemaExternoResponse buscarPorIdConfiguracion(Integer idConfiguracion) {
        return configSistemaExternoDaoResponse.findByIdConfiguracion(idConfiguracion);
    }

    @Override
	public String buscarPorIdConfiguracionCompleta(Integer idConfiguracion) {
			
		Integer idConfiguracionPadre =0;
		String urlBase = "";
		while(idConfiguracionPadre != null){
			//Buscar configuración por id
			ConfiguracionSistemaExternoResponse configuracion = buscarPorIdConfiguracion(idConfiguracion);
			//Concatenar url
			urlBase = configuracion.getValor().concat(urlBase);
			//Asignar configuración padre asociada
			idConfiguracion = configuracion.getIdConfiguracionPadre();
			idConfiguracionPadre = idConfiguracion;
		}
		
		return urlBase;
	}

    @Override
    public List<ConfiguracionSistemaExternoResponse> buscarPorFiltros(
            ConfiguracionSistemaExternoFilter configuracionSistemaExternoFilter) {

        return configSistemaExternoDaoResponse.buscarPorFiltros(configuracionSistemaExternoFilter);
    }

    @Override
    public ConfiguracionSistemaExternoResponse registrarConfiguracion(
            ConfiguracionSistemaExternoRequest configuracionSistemaExternoRequest) {
            configuracionSistemaExternoDao.saveAndFlush(configuracionSistemaExternoRequest);
        return buscarPorIdConfiguracion(configuracionSistemaExternoRequest.getIdConfiguracion());
    }
    @Override
    public ConfiguracionSistemaExternoResponse actualizarConfiguracion(Integer idConfiguracion,
            ConfiguracionSistemaExternoRequest configuracionSistemaExternoRequest) {
            configuracionSistemaExternoRequest.setIdConfiguracion(idConfiguracion);
            configuracionSistemaExternoDao.saveAndFlush(configuracionSistemaExternoRequest);
        return buscarPorIdConfiguracion(configuracionSistemaExternoRequest.getIdConfiguracion());
    }
    @Override
    public void eliminarConfiguracion(ConfiguracionSistemaExternoRequest configuracionSistemaExternoRequest) {
        configuracionSistemaExternoDao.delete(configuracionSistemaExternoRequest);
    }
    
}
