/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.service;

import com.primerproyecto.miportfolio.model.entities.Proyectos;
import com.primerproyecto.miportfolio.model.entities.Skills;
import com.primerproyecto.miportfolio.repository.ProyectosRepository;
import com.primerproyecto.miportfolio.repository.SkillsRepository;
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

public class SkillsService {
    
    
    private final SkillsRepository skillsRepository;

    @Autowired
    
    public SkillsService(SkillsRepository   skillsRepository){
        
        this.skillsRepository= skillsRepository;
    }
    
    public Skills agregarSkills(Skills skill){ //metodo para agregar y que se guarde
        return skillsRepository.save(skill);
    }
    
    public List<Skills> buscarSkills(){ //metodo para buscar y mostrar educaciones
        return skillsRepository.findAll();
        
    }
    
    public Skills editarSkills(Skills skill){ //metodo para editar
        return skillsRepository.save(skill);
        

    
    }

 public void borrarSkills(Long id){     //metodo para borrar
        skillsRepository.deleteById(id);
    }
 

}