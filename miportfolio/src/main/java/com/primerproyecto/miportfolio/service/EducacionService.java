/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.service;

import com.primerproyecto.miportfolio.model.entities.Educacion;
import com.primerproyecto.miportfolio.repository.EducacionRepository;
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

public class EducacionService {
    private final EducacionRepository educacionRepository;
    
    @Autowired
    
    public EducacionService(EducacionRepository  educacionRepository){
        this.educacionRepository = educacionRepository;
    }
    
    public Educacion agregarEducacion(Educacion educacion){ //metodo para agregar y que se guarde
        return educacionRepository.save(educacion);
    }
    
    public List<Educacion> buscarEducaciones(){ //metodo para buscar y mostrar educaciones
        return educacionRepository.findAll();
        
    }
    
    public Educacion editarEducacion(Educacion educacion){ //metodo para editar
        return educacionRepository.save(educacion);
        
    }
            
    public void borrarEducacion(Long id){     //metodo para borrar
        educacionRepository.deleteById(id);
        
    }
    
}

