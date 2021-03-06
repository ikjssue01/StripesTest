/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.accesos.controllers;

import javax.validation.Valid;
import org.ms.rrhh.rest.accesos.controllers.handlers.CrearAcHandler;
import org.ms.rrhh.rest.dto.AccesoDto;
import org.ms.rrhh.rest.dto.converters.AccesoDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author eliud
 */
@Controller("crearAcceso")
@RequestMapping("accesos")
public class CrearController {

    @Autowired
    CrearAcHandler crear;

    @Transactional
    @RequestMapping(value = "/crea", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public @ResponseBody
    AccesoDto crear(@RequestBody @Valid AccesoDto acceso) {
        return new AccesoDtoConverter().toDTO(crear.handle(acceso));
    }
}
