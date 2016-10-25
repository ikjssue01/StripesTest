/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.services;

import java.util.List;
import org.ms.rrhh.dao.PersonasDao;
import org.ms.rrhh.domain.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edcracken
 */
@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    PersonasDao dao;

    @Override
    public List<Persona> getPersonas() {
        return dao.getAll();
    }

    public PersonasDao getDao() {
        return dao;
    }

    public void setDao(PersonasDao dao) {
        this.dao = dao;
    }

}
