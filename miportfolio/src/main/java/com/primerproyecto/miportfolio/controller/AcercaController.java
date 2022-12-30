/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.controller;

import com.primerproyecto.miportfolio.model.entities.Acerca;
import com.primerproyecto.miportfolio.model.entities.Skills;

import com.primerproyecto.miportfolio.service.AcercaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/acerca")
public class AcercaController {
    
    
    
     private final AcercaService acercaService;
    
    public AcercaController(AcercaService acercaService){
        this.acercaService = acercaService;
        
        
    }
    
    @PostMapping ("/crearacerca")

public ResponseEntity<Acerca> crearAcerca(@RequestBody Acerca acerca){

Acerca crearAcerca= acercaService.agregarAcerca(acerca);
return new ResponseEntity<>(crearAcerca,HttpStatus.OK);
}
    
    
    @GetMapping("/id/{id}")
    
    public ResponseEntity<Acerca> obtenerAcerca(@PathVariable("id") Long id){
        
        Acerca acerca=acercaService.buscarAcercade(id);
        
        return new ResponseEntity<>(acerca, HttpStatus.OK);
    }
    
    
    @PutMapping ("/update")
            
public ResponseEntity<Acerca> editarAcerca(@RequestBody Acerca acerca){

Acerca updateAcerca=acercaService.editarAcerca(acerca);
return new ResponseEntity<>(updateAcerca,HttpStatus.OK);
}


@DeleteMapping ("/borrar/{id}")

public void  borrarAcerca(@PathVariable Long id){
acercaService.borrarAcerca(id);


}
}