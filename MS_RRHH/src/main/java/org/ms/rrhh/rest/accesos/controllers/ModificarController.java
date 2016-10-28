/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.accesos.controllers;

import org.ms.rrhh.rest.accesos.controllers.handlers.ModificarAcHandler;
import org.ms.rrhh.rest.dto.AccesoDto;
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
@Controller("modificarRole")
@RequestMapping("accesos")
public class ModificarController {

    @Autowired
    ModificarAcHandler handler;

    @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT, headers = "Content-Type=application/json")
    public void modificar(@PathVariable("id") Integer id, @RequestBody AccesoDto acceso) {
        handler.handle(acceso);
    }
}
