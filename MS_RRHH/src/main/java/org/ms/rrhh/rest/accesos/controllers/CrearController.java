/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.accesos.controllers;

import org.ms.rrhh.rest.roles.controllers.*;
import org.ms.rrhh.domain.model.Role;
import org.ms.rrhh.domain.utils.BeansConverter;
import org.ms.rrhh.rest.dto.RoleDto;
import org.ms.rrhh.rest.roles.controllers.handlers.CrearHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eliud
 */
@Controller("crearRole")
@RequestMapping("roles")
public class CrearController {

    @Autowired
    CrearHandler crear;

    @RequestMapping(value = "/crea", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public RoleDto crear(@RequestBody RoleDto persona) {
        return new BeansConverter<Role, RoleDto>().toDTO(crear.handle(persona));
    }
}
