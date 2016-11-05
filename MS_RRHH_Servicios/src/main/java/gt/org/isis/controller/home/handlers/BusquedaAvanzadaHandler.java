/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.home.handlers;

import gt.org.isis.api.AbstractValidationsRequestHandler;
import gt.org.isis.controller.dto.BusquedaAvanzadaDto;
import gt.org.isis.controller.dto.PageableResultDto;
import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.repository.LugarResidenciaRepository;
import gt.org.isis.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author edcracken
 */
public class BusquedaAvanzadaHandler extends AbstractValidationsRequestHandler<BusquedaAvanzadaDto, PageableResultDto<PersonaDto>> {

    @Autowired
    PersonasRepository repo;

    @Autowired
    LugarResidenciaRepository lugarRepo;

    @Override
    public PageableResultDto<PersonaDto> execute(final BusquedaAvanzadaDto request) {
        
        return null;
    }

}
