package com.example.jpa.dao;


import com.example.jpa.model.request.ConfiguracionSistemaExternoRequest;

import org.springframework.data.jpa.repository.JpaRepository;
public interface IConfiguracionSistemaExternoDao extends JpaRepository<ConfiguracionSistemaExternoRequest, Long> {
    
}
