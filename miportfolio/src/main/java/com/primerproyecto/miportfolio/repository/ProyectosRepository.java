/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.repository;

import com.primerproyecto.miportfolio.model.entities.Educacion;
import com.primerproyecto.miportfolio.model.entities.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Romi
 */


public interface ProyectosRepository extends JpaRepository<Proyectos, Long>{
    
}
