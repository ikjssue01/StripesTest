/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.roles.controllers;

import org.ms.rrhh.rest.usuarios.controllers.*;
import org.ms.rrhh.rest.personas.controllers.*;
import org.ms.rrhh.rest.dto.PersonaDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author eliud
 */
@Controller
@RequestMapping("personas")
public class Crear {

    @RequestMapping("/")
    public void crear(@RequestBody PersonaDto persona) {
        
    }
}
