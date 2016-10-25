/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eliud
 */
@XmlRootElement
public class PersonaDto {

    private String nombre;
    private String segundoNombre;

    public PersonaDto(String nombre) {
        this.nombre = nombre;
        this.segundoNombre = "testme";
    }

    public PersonaDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

}
