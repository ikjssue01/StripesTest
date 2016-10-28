/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.accesos.controllers.handlers;

import org.ms.rrhh.api.AbstractRequestHandler;
import org.ms.rrhh.dao.AccesosDao;
import org.ms.rrhh.rest.dto.AccesoDto;
import org.ms.rrhh.rest.dto.converters.AccesoDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author edcracken
 */
@Component
public class BuscarAcHandler extends AbstractRequestHandler<AccesoDto, AccesoDto> {

    @Autowired
    AccesosDao accesos;

    @Override
    public AccesoDto execute(final AccesoDto request) {
        return new AccesoDtoConverter().toDTO(accesos.getOne(request.getId()));
    }

}
