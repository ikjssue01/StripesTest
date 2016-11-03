/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.personas.handlers.validations;

import gt.org.isis.api.IValidationRequest;
import gt.org.isis.api.ValidationRequestContext;
import static gt.org.isis.api.ValidationsHelper.isNull;
import gt.org.isis.api.misc.exceptions.ExceptionsManager;
import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.controller.personas.handlers.PersonaCrearHandler;
import gt.org.isis.repository.PersonasRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author edcracken
 */
@Component
public class ExistePersonaValidation implements IValidationRequest<PersonaDto> {

    @Autowired
    PersonasRepository repo;

    @Override
    public void validate(PersonaDto persona, ValidationRequestContext ctx) {
        if (!isNull(repo.findOne(persona.getCui()))) {
            throw ExceptionsManager.newValidationException("persona_existe",
                    Arrays.asList("cui_persona,Persona con CUI ya existe!")
                            .toArray(new String[1]));
        }
    }

}
