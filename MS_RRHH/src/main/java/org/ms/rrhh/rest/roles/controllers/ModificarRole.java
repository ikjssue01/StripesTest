/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.roles.controllers;

import org.ms.rrhh.rest.dto.PersonaDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eliud
 */
@Controller("modificarRole")
@RequestMapping("roles")
public class ModificarRole {

    @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT, headers = "Content-Type=application/json")
    public void modificar(@PathVariable("id") Integer id, @RequestBody PersonaDto persona) {

    }
}
