/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.controller;


import com.primerproyecto.miportfolio.model.entities.Skills;

import com.primerproyecto.miportfolio.service.SkillsService;
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
@RequestMapping("/skills")

public class SkillsController {
    
    
    

        private final SkillsService skillsService;
    
    public SkillsController(SkillsService skillsService){
        this.skillsService = skillsService;
        
        
    }
    
    
    @GetMapping("/skills")
    
    public ResponseEntity<List<Skills>> obtenerSkill(){
        
        List<Skills> skills=skillsService.buscarSkills();
        
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    
    
    @PutMapping ("/update")
            
public ResponseEntity<Skills> editarSkill(@RequestBody Skills skill){

Skills updateSkills=skillsService.editarSkills(skill);
return new ResponseEntity<>(updateSkills,HttpStatus.OK);
}



@PostMapping ("/crearskill")

public ResponseEntity<Skills> crearSkill(@RequestBody Skills skill){

Skills crearSkill=skillsService.agregarSkills(skill);
return new ResponseEntity<>(crearSkill,HttpStatus.OK);
}


@DeleteMapping ("/borrar/{id}")

public void  borrarSkill(@PathVariable Long id){
skillsService.borrarSkills(id);

}


}
    
 
 



    
