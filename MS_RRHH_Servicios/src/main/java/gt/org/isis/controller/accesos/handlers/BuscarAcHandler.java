/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.accesos.handlers;

import gt.org.isis.api.AbstractRequestHandler;
import gt.org.isis.controller.dto.AccesoDto;
import gt.org.isis.converters.AccesoDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import gt.org.isis.repository.AccesosRepository;

/**
 *
 * @author edcracken
 */
@Component
public class BuscarAcHandler extends AbstractRequestHandler<AccesoDto, AccesoDto> {

    @Autowired
    AccesosRepository accesos;

    @Override
    public AccesoDto execute(final AccesoDto request) {
        return new AccesoDtoConverter().toDTO(accesos.findOne(request.getId()));
    }

}
