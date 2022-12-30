/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.service;

import com.primerproyecto.miportfolio.model.entities.Acerca;
import com.primerproyecto.miportfolio.model.entities.Persona;
import com.primerproyecto.miportfolio.repository.AcercaRepository;
import com.primerproyecto.miportfolio.repository.PersonaRepository;
import jakarta.persistence.Id;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Romi
 */


@Service

@Transactional

public class AcercaService {
    
    
    private final AcercaRepository acercaRepository;
    
    @Autowired
    
    public AcercaService(AcercaRepository   acercaRepository){
        
        this.acercaRepository= acercaRepository;
    }
    
    public Acerca agregarAcerca(Acerca acerca){ //metodo para agregar y que se guarde
        return acercaRepository.save(acerca);
    }
    
    public Acerca buscarAcercade(Long id){ //metodo para buscar y mostrar 
        return acercaRepository.findById(id).get(); //devuelve una sola descripcion
        
       
              
    }
    
    public Acerca editarAcerca(Acerca acerca){ //metodo para editar
        return acercaRepository.save(acerca);
        

    
    }

 public void borrarAcerca(Long id){     //metodo para borrar
        acercaRepository.deleteById(id);
    }
 
 
}
    


