/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.home.controllers;

import java.util.Arrays;
import java.util.List;
import org.ms.rrhh.api.AbstractRequestHandler;
import org.ms.rrhh.dao.PersonasDao;
import org.ms.rrhh.domain.model.Persona;
import org.ms.rrhh.domain.utils.BeansConverter;
import org.ms.rrhh.rest.dto.BusquedaAvanzadaDto;
import org.ms.rrhh.rest.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/busqueda")
public class BusquedaAvanzada extends AbstractRequestHandler<BusquedaAvanzadaDto, List<PersonaDto>> {

    @Autowired
    PersonasDao personas;

    @RequestMapping(value = "/avanzada", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public @ResponseBody
    List<PersonaDto> getPersonas(@RequestBody BusquedaAvanzadaDto busqueda) {
        return this.handle(busqueda);
    }

    @Override
    public List<PersonaDto> execute(BusquedaAvanzadaDto request) {
        return new BeansConverter<Persona, PersonaDto>().toDTO(personas.busquedaAvanzada(request));
    }

}
