/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.controller;

import com.primerproyecto.miportfolio.model.entities.Educacion;

import com.primerproyecto.miportfolio.service.EducacionService;

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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")

public class EducacionController {
    
        private final EducacionService educacionService;
    
    public EducacionController(EducacionService educacionService){
        this.educacionService = educacionService;
        
        
    }
    
    
    @GetMapping("/educaciones")
    
    public ResponseEntity<List<Educacion>> obtenerEducacion(){
        
        List<Educacion> educaciones=educacionService.buscarEducaciones();
        
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }
    
    
    @PutMapping ("/update")
            
public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion){

Educacion updateEducacion=educacionService.editarEducacion(educacion);
return new ResponseEntity<>(updateEducacion,HttpStatus.OK);
}

@PostMapping ("/crearedu")

public ResponseEntity<Educacion> crearEducacion(@RequestBody Educacion educacion){

Educacion crearEducacion=educacionService.agregarEducacion(educacion);
return new ResponseEntity<>(crearEducacion,HttpStatus.OK);
}


@DeleteMapping ("/borrar/{id}")

public void  borrarEducacion(@PathVariable Long id){
educacionService.borrarEducacion(id);

}


}
  
    
