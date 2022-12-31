/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.controller;

import com.primerproyecto.miportfolio.model.entities.Experiencia;

import com.primerproyecto.miportfolio.service.ExperienciaService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Romi
 */

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")

public class ExperienciaController {
    
        private final ExperienciaService experienciaService;
    
    public ExperienciaController(ExperienciaService experienciaService){
        this.experienciaService = experienciaService;
        
        
    }
    
    
    @GetMapping("/experiencias")
    
    public ResponseEntity<List<Experiencia>> obtenerExperiencia(){
        
        List<Experiencia> experiencias=experienciaService.buscarExperiencias();
        
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }
    
    
    @PutMapping ("/update")
            
public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia experiencia){

Experiencia updateExperiencia=experienciaService.editarExperiencia(experiencia);
return new ResponseEntity<>(updateExperiencia,HttpStatus.OK);
}

@PostMapping ("/crearexpe")

public ResponseEntity<Experiencia> crearExperiencia(@RequestBody Experiencia experiencia){

Experiencia crearExperiencia=experienciaService.agregarExperiencia(experiencia);
return new ResponseEntity<>(crearExperiencia,HttpStatus.OK);
}


@DeleteMapping ("/borrar/{id}")

public void  borrarExperiencia(@PathVariable Long id){
experienciaService.borrarExperiencia(id);

}


}
    