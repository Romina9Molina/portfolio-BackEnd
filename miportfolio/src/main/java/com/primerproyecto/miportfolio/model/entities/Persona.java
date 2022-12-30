/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primerproyecto.miportfolio.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;
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

public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    
    private int id;
    private String nombre;
    private String apellido;
    private String título;
    private String mail;
    
   @Column(name="url_foto") 
    private String url;
    private String localidad;
    
    
   // @OneToOne(fetch = FetchType.LAZY, mappedBy = "id")
    //private Acerca acerca;
    
    
   /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")    
    private List<Educacion> educacionList;
    
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Experiencia> experienciaList;
    
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Proyectos> proyectosList;
    
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Skills> skillsList; */
}
