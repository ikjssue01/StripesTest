/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.personas.handlers;

import gt.org.isis.api.AbstractRequestHandler;
import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edcracken
 */
@Service
public class PersonaCrearHandler extends AbstractRequestHandler<PersonaDto, Boolean> {

    @Autowired
    PersonasRepository repo;

    @Override
    public Boolean execute(PersonaDto request) {

        return true;
    }

}
