/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.accesos.handlers;

import gt.org.isis.api.AbstractRequestHandler;
import gt.org.isis.controller.dto.AccesoDto;
import gt.org.isis.converters.AccesoDtoConverter;
import gt.org.isis.model.Acceso;
import gt.org.isis.model.utils.EntitiesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import gt.org.isis.repository.AccesosRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author edcracken
 */
@Service
public class CrearAcHandler extends AbstractRequestHandler<AccesoDto, Acceso> {

    @Autowired
    AccesosRepository accesos;

    @Override
    public Acceso execute(final AccesoDto request) {
        final Acceso r = new AccesoDtoConverter().toEntity(request);
        EntitiesHelper.setDateCreateRef(r);

        accesos.save(r);
        return r;
    }

}
