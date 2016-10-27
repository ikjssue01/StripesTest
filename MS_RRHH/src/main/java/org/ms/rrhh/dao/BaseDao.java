/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import org.ms.rrhh.api.QuerySpecification;
import org.ms.rrhh.domain.model.Persona;

/**
 *
 * @author edcracken
 * @param <T>
 */
public class BaseDao<T> {

    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void executeQuery(QuerySpecification spec) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> c = cb.createQuery(Class<T>);
        Root<T> root = c.from(Class<T>);
        EntityType<Persona> type = entityManager.getMetamodel().entity(Persona.class);
    }
}
