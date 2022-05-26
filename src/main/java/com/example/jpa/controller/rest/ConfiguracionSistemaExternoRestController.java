package com.example.jpa.controller.rest;

import java.util.List;

import javax.validation.Valid;

import com.example.jpa.model.filter.ConfiguracionSistemaExternoFilter;
import com.example.jpa.model.request.ConfiguracionSistemaExternoRequest;
import com.example.jpa.model.response.ConfiguracionSistemaExternoResponse;
import com.example.jpa.service.ConfiguracionSistemaExternoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Recibe las solicitudes relacionadas al mantenimiento de Configuracion sistema externo 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Mostrar la url completo por el identificador de configuracion
 * 	<li>Buscar todas las configuraciones
 * 	<li>Búsqueda de una configuracion
 * 	<li>Registro de una configuracion
 * 	<li>Actualización de una configuracion
 * 	<li>Eliminación de una configuracion
 * </ul>
 * 
 * @author Gonzalo Artadi
 * @see ConfiguracionSistemaExternoRequest
 * @see ConfiguracionSistemaExternoResponse
 * @see ConfiguracionSistemaExternoService
 */
@Validated
@RestController
@RequestMapping("/configuracion-sis-ext")
public class ConfiguracionSistemaExternoRestController {
	
	@Autowired
	private ConfiguracionSistemaExternoService configuracionSistemaExternoService;
	/**
	 * Retorna una url completa de la configuracion por el atributo:
	 * @param idConfiguracion
	 * 			código de configuracion
	 * @return	url completa
	 */
	@GetMapping("/buscar/{idConfiguracion}")
	public String buscarPorIdConfiguracionCompleta(@PathVariable("idConfiguracion") Integer idConfiguracion) {
		return configuracionSistemaExternoService.buscarPorIdConfiguracionCompleta(idConfiguracion);
	}

	/**
	 * Retorna una lista de todas las configuraciones buscados 
	 * @return	lista de configuraciones obtenido por búsqueda es de tipo:
	 * 			{@link ConfiguracionSistemaExternoResponse}
	 */
	@GetMapping("/")
	public List<ConfiguracionSistemaExternoResponse> buscarTodos(){
		return configuracionSistemaExternoService.buscarTodos();
	}
	
	/**
	 * Retorna una configuracion buscado por atributo:  
	 * @param idConfiguracion
	 * 			código de configuracion a buscar	
	 * @return	configuracion obtenida por búsqueda es de tipo:
	 * 			{@link ConfiguracionSistemaExternoResponse}
	 */
	@GetMapping("/{idConfiguracion}")
	public ConfiguracionSistemaExternoResponse buscarPorIdConfigSistemaExterno(
			@PathVariable("idConfiguracion") Integer idConfiguracion){
		return configuracionSistemaExternoService.buscarPorIdConfiguracion(idConfiguracion);
	}
	@PostMapping("/filtros")
	public List<ConfiguracionSistemaExternoResponse> buscarPorIdConfigSistemaExterno(
		@Valid @RequestBody ConfiguracionSistemaExternoFilter configuracionSistemaExternoFilter){
		return configuracionSistemaExternoService.buscarPorFiltros(configuracionSistemaExternoFilter);
	}
	
	/**
	 * Recibe petición de registro de una configuracion
	 * @param configuracionSistemaExternoRequest
	 * 			configuracion a registrar.
	 * @return	configuracion registrado.
	 * 			{@link ConfiguracionSistemaExternoResponse}
	 */
	@PostMapping("/")
	public ConfiguracionSistemaExternoResponse registrarConfigSistemaExterno(
			@Valid @RequestBody ConfiguracionSistemaExternoRequest configuracionSistemaExternoRequest) {
		return configuracionSistemaExternoService.registrarConfiguracion(configuracionSistemaExternoRequest);
	}
	
	
	/**
	 * Recibe petición de actualización de una configuracion.  
	 * @param idConfiguracion
	 * 			el código de la configuracion
	 * @param configuracionSistemaExternoRequest
	 * 			configuracion a actualizar
	 * @return	configuracion actualizado
	 * 			{@link ConfiguracionSistemaExternoResponse}
	 */
	@PutMapping("/{idConfiguracion}")
	public ConfiguracionSistemaExternoResponse actualizarConfigSistemaExterno(
			@PathVariable("idConfiguracion") Integer idConfiguracion
		,   @Valid @RequestBody ConfiguracionSistemaExternoRequest configuracionSistemaExternoRequest) {
		return configuracionSistemaExternoService.actualizarConfiguracion(idConfiguracion, configuracionSistemaExternoRequest);
	}
	
	
	/**
	 * Recibe petición de eliminación de una configuracion.  
	 * @param idConfiguracion
	 * 			el código de configuracion
	 * 		
	 */
	@DeleteMapping("/{idConfiguracion}")
	public void eliminarConfigSistemaExterno(
			@PathVariable("idConfiguracion") Integer idConfiguracion) {
		configuracionSistemaExternoService.eliminarConfiguracion(ConfiguracionSistemaExternoRequest.builder().idConfiguracion(idConfiguracion).build());
	}
}
