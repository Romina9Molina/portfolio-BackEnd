/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.service;

import com.primerproyecto.miportfolio.model.entities.Educacion;
import com.primerproyecto.miportfolio.model.entities.Experiencia;
import com.primerproyecto.miportfolio.repository.EducacionRepository;
import com.primerproyecto.miportfolio.repository.ExperienciaRepository;
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

public class ExperienciaService {
    private final ExperienciaRepository experienciaRepository;
    
    @Autowired
    
    public ExperienciaService(ExperienciaRepository  experienciaRepository){
        this.experienciaRepository = experienciaRepository;
    }
    
    public Experiencia agregarExperiencia(Experiencia experiencia){ //metodo para agregar y que se guarde
        return experienciaRepository.save(experiencia);
    }
    
    public List<Experiencia> buscarExperiencias(){ //metodo para buscar y mostrar educaciones
        return experienciaRepository.findAll();
        
    }
    
    public Experiencia editarExperiencia(Experiencia experiencia){ //metodo para editar
        return experienciaRepository.save(experiencia);
        

    
    }

 public void borrarExperiencia(Long id){     //metodo para borrar
        experienciaRepository.deleteById(id);
    }
 
 
}