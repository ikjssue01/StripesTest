/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.ms.rrhh.domain.model.Persona;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author edcracken
 */
@Repository
public class PersonasDaoImpl implements PersonasDao {

    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public List<Persona> getAll() throws DataAccessException {
        Query query = getEntityManager().createQuery("select c from Car c");
        List<Persona> resultList = query.getResultList();
        return resultList;
    }

    @Transactional
    @Override
    public Persona getOne(Long carId) throws DataAccessException {
        return getEntityManager().find(Persona.class, carId);
    }

}
