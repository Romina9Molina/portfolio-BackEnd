/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.service;

import com.primerproyecto.miportfolio.model.entities.Acerca;
import com.primerproyecto.miportfolio.model.entities.Proyectos;
import com.primerproyecto.miportfolio.repository.AcercaRepository;
import com.primerproyecto.miportfolio.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Romi
 */

@Service

@Transactional

public class ProyectosService {
    
    
    private final ProyectosRepository proyectosRepository;
    
    @Autowired
    
    public ProyectosService(ProyectosRepository   proyectosRepository){
        
        this.proyectosRepository= proyectosRepository;
    }
    
    public Proyectos agregarProyectos(Proyectos proyecto){ //metodo para agregar y que se guarde
        return proyectosRepository.save(proyecto);
    }
    
    public List<Proyectos> buscarProyectos(){ //metodo para buscar y mostrar 
        return proyectosRepository.findAll();
        
    }
    
    public Proyectos editarProyectos(Proyectos proyecto){ //metodo para editar
        return proyectosRepository.save(proyecto);
        

    
    }

 public void borrarProyectos(Long id){     //metodo para borrar
        proyectosRepository.deleteById(id);
    }
 
 
}
    




