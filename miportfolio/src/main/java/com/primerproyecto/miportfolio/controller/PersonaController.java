/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.controller;

import com.primerproyecto.miportfolio.model.entities.Acerca;
import com.primerproyecto.miportfolio.model.entities.Persona;
import com.primerproyecto.miportfolio.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
@RequestMapping("/usuario")

public class PersonaController {
    private final PersonaService personaService;
    
    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
        
        
    }
    
    
    @PostMapping ("/crearpersona")

public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){

Persona crearPersona= personaService.agregarPersona(persona);
return new ResponseEntity<>(crearPersona,HttpStatus.OK);
}
    
    
    @GetMapping("/id/{id}")
    
    public ResponseEntity<Persona> obtenerPersona(@PathVariable("id") Long id){
        
        Persona persona=personaService.buscarPersonaPoRId(id);
        
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    
    @PutMapping ("/update")
            
public ResponseEntity<Persona> editarPersona(@RequestBody Persona persona){

Persona updatePersona=personaService.editarPersona(persona);
return new ResponseEntity<>(updatePersona,HttpStatus.OK);
}




}