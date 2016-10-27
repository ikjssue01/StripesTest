/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.home.controllers;

import java.util.Arrays;
import java.util.List;
import org.ms.rrhh.api.AbstractRequestHandler;
import org.ms.rrhh.rest.dto.BusquedaNormalDto;
import org.ms.rrhh.rest.dto.PersonaDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author edcracken
 */
@Controller
@RequestMapping("busqueda")
public class BusquedaNormal extends AbstractRequestHandler<BusquedaNormalDto, List<PersonaDto>> {

    @RequestMapping(value = "/normal", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public @ResponseBody
    List<PersonaDto> getPersonas(@RequestBody BusquedaNormalDto busqueda) {
        return null;
    }

    @Override
    public List<PersonaDto> execute(BusquedaNormalDto request) {
        return Arrays.asList(new PersonaDto("edcracken"));
    }

}
