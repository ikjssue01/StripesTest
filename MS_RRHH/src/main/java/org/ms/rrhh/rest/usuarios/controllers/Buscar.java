/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.usuarios.controllers;

import org.ms.rrhh.rest.dto.PersonaDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author edcracken
 */
@Controller("rolesuBuscar")
@RequestMapping("roles")
public class Buscar {

    @RequestMapping("/{id}")
    public @ResponseBody
    PersonaDto getPersona(@PathVariable("cui") String cui) {
        return null;
    }
}
