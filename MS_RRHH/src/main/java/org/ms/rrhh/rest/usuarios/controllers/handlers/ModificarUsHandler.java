/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.usuarios.controllers.handlers;

import org.ms.rrhh.rest.accesos.controllers.handlers.*;
import org.ms.rrhh.api.AbstractRequestHandler;
import org.ms.rrhh.dao.AccesoDao;
import org.ms.rrhh.domain.model.Acceso;
import org.ms.rrhh.rest.dto.AccesoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author edcracken
 */
@Component
public class ModificarUsHandler extends AbstractRequestHandler<AccesoDto, Acceso> {

    @Autowired
    AccesoDao accesos;

    @Override
    public Acceso execute(final AccesoDto request) {
        Acceso origin = accesos.getOne(request.getId());
        BeanUtils.copyProperties(request, origin);
        accesos.update(origin);
        return origin;
    }

}
