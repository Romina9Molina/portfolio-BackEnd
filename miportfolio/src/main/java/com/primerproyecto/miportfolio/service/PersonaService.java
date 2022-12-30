/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.service;

import com.primerproyecto.miportfolio.exception.UserNotFoundException;
import com.primerproyecto.miportfolio.model.entities.Experiencia;
import com.primerproyecto.miportfolio.model.entities.Persona;
import com.primerproyecto.miportfolio.repository.ExperienciaRepository;
import com.primerproyecto.miportfolio.repository.PersonaRepository;
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

public class PersonaService {
    
    
    private final PersonaRepository personaRepository;
    
    @Autowired
    
    public PersonaService(PersonaRepository   personaRepository){
        
        this.personaRepository= personaRepository;
    }
    
    // Como persona solo hay una y no voy a agregar  al portfolio este metodo esta demas
    
    public Persona agregarPersona(Persona persona){ //metodo para agregar y que se guarde
        return personaRepository.save(persona);
    }
    
    //public List<Persona> buscarPersonas(){ //metodo para buscar y mostrar la persona
      //  return personaRepository.findAll();
        
   // }
    
    public Persona editarPersona(Persona persona){ //metodo para editar
        return personaRepository.save(persona);
        

    
    }

 public void borrarPersona(Long id){     //metodo para borrar
        personaRepository.deleteById(id);
    }
 
 
 public Persona buscarPersonaPoRId(Long id){
     return personaRepository.findById(id).orElseThrow(() ->new UserNotFoundException("Usuario no encontrado"));
 }

   
 
}
    

