/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.roles.controllers;

import org.ms.rrhh.rest.dto.RoleDto;
import org.ms.rrhh.rest.roles.controllers.handlers.ModificarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eliud
 */
@Controller("modificarAcceso")
@RequestMapping("accesos")
public class ModificarController {

    @Autowired
    ModificarHandler handler;

    @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT, headers = "Content-Type=application/json")
    public void modificar(@PathVariable("id") Integer id, @RequestBody RoleDto persona) {
        handler.handle(persona);
    }
}
