/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.dao;

import java.util.List;
import org.ms.rrhh.domain.model.Persona;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author edcracken
 */
public interface PersonasDao {

    public List<Persona> getAll() throws DataAccessException;

    public Persona getOne(Long carId) throws DataAccessException;
}
