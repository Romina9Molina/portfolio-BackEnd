/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.controller;


import com.primerproyecto.miportfolio.model.entities.Proyectos;

import com.primerproyecto.miportfolio.service.ProyectosService;
import java.util.List;
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
@RequestMapping("/proyectos")
public class ProyectosController {
    private final ProyectosService proyectoService;
    
    public ProyectosController(ProyectosService proyectoService){
        this.proyectoService = proyectoService;
        
        
    }
    
    
    @GetMapping("/proyectos")
    
    public ResponseEntity<List<Proyectos>> obtenerProyectos(){
        
        List<Proyectos> proyectos=proyectoService.buscarProyectos();
        
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }
    
    
    @PutMapping ("/update")
            
public ResponseEntity<Proyectos> editarProyectos(@RequestBody Proyectos proyecto){

Proyectos updateProyecto=proyectoService.editarProyectos(proyecto);
return new ResponseEntity<>(updateProyecto,HttpStatus.OK);
}

@PostMapping ("/crearpro")

public ResponseEntity<Proyectos> crearProyecto(@RequestBody Proyectos proyecto){

Proyectos crearProyecto=proyectoService.agregarProyectos(proyecto);
return new ResponseEntity<>(crearProyecto,HttpStatus.OK);
}


@DeleteMapping ("/borrar/{id}")

public void  borrarProyecto(@PathVariable Long id){
proyectoService.borrarProyectos(id);

}


}
  

