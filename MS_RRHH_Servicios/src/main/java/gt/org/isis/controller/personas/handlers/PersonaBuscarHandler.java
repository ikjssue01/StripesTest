/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.personas.handlers;

import gt.org.isis.api.AbstractRequestHandler;
import static gt.org.isis.api.ValidationsHelper.isNull;
import gt.org.isis.api.misc.exceptions.ExceptionsManager;
import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.converters.PersonaDtoConverter;
import gt.org.isis.model.Persona;
import gt.org.isis.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edcracken
 */
@Service
public class PersonaBuscarHandler extends AbstractRequestHandler<String, PersonaDto> {

    @Autowired
    PersonasRepository repo;

    @Override
    public PersonaDto execute(String request) {
        Persona p = repo.findOne(request);
        if (isNull(p)) {
            throw ExceptionsManager.newNotFound();
        }
        return new PersonaDtoConverter().toDTO(p);
    }

}
