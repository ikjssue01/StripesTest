/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.roles.controllers;

import org.ms.rrhh.rest.dto.RoleDto;
import org.ms.rrhh.rest.roles.controllers.handlers.BuscarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author edcracken
 */
@Controller("getRole")
@RequestMapping("roles")
public class BuscarController {

    @Autowired
    BuscarHandler handler;

    @RequestMapping("/get/{id}")
    public @ResponseBody
    RoleDto getRole(@PathVariable("id") Integer id) {
        return handler.handle(new RoleDto(id));
    }
}
