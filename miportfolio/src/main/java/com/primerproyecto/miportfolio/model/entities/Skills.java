/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Romi
 */


@Getter @Setter
@AllArgsConstructor //constructor con todos los argumentos
@NoArgsConstructor //constructor sin argumentos
@Entity


public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_Skills")
    
    
    
    private int id;
    private String habilidad;
    private float nivel;
    
    @Column(name = "Persona_id")
    private int personaId;

}
