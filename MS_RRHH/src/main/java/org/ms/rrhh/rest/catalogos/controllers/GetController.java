/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.catalogos.controllers;

import java.util.List;
import org.ms.rrhh.api.AbstractRequestHandler;
import org.ms.rrhh.rest.dto.CatalogoDto;
import org.ms.rrhh.rest.dto.CatalogosReqDto;
import org.ms.rrhh.rest.dto.PersonaDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author edcracken
 */
@Controller
@RequestMapping("catalogos")
public class GetController extends AbstractRequestHandler<CatalogosReqDto, List<CatalogoDto>> {

    @RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public @ResponseBody
    List<PersonaDto> getCatalogos(@RequestParam String tipo, @RequestParam(required = false) Integer padre) {
        return null;
    }

    @Override
    public List<CatalogoDto> execute(CatalogosReqDto request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
