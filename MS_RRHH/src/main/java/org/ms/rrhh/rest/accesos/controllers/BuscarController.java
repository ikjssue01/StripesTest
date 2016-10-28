/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.accesos.controllers;

import org.ms.rrhh.rest.accesos.controllers.handlers.BuscarAcHandler;
import org.ms.rrhh.rest.dto.AccesoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author edcracken
 */
@Controller("getAcceso")
@RequestMapping("accesos")
public class BuscarController {

    @Autowired
    BuscarAcHandler handler;

    @RequestMapping("/get/{id}")
    public @ResponseBody
    AccesoDto getRole(@PathVariable("id") Integer id) {
        return handler.handle(new AccesoDto(id));
    }
}
