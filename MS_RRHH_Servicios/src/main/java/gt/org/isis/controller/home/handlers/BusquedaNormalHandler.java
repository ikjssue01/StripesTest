/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.home.handlers;

import gt.org.isis.api.AbstractValidationsRequestHandler;
import gt.org.isis.controller.dto.BusquedaNormalDto;
import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.model.Persona;
import gt.org.isis.repository.PersonasRepository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author edcracken
 */
public class BusquedaNormalHandler extends AbstractValidationsRequestHandler<BusquedaNormalDto, PersonaDto> {

    @Autowired
    PersonasRepository repo;

    @Override
    public PersonaDto execute(BusquedaNormalDto request) {
        repo.findAll(new Specification<Persona>() {
            @Override
            public Predicate toPredicate(Root<Persona> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        return null;
    }

}
