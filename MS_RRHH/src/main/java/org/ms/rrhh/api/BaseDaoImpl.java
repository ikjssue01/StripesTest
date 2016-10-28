/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.api;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.ms.rrhh.domain.model.CustomEntity;
import org.ms.rrhh.domain.utils.EntitiesHelper;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eliud
 * @param <T>
 */
public class BaseDaoImpl<T extends CustomEntity> {

    @PersistenceUnit(unitName = "ms_rrhh")
    private EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

//    @PersistenceContext
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
    @Transactional
    public void save(T entity) throws DataAccessException {
        EntitiesHelper.setDateCreateRef(entity);
        getEntityManager().persist(entity);
    }

    @Transactional
    public void update(T entity) throws DataAccessException {
        EntitiesHelper.setDateUpdateRef(entity);
        getEntityManager().merge(entity);
    }

    @Transactional
    public void delete(T entity) throws DataAccessException {
        getEntityManager().remove(entity);
    }

    @Transactional
    public T getOne(Serializable id) throws DataAccessException {
        return getEntityManager().find(getClazz(), id);
    }

    @Transactional
    public List<T> getAll() throws DataAccessException {
        return getEntityManager()
                .createQuery("select t from ".concat(getClazz().getSimpleName().concat(" t")))
                .getResultList();
    }

    private Class<T> getClazz() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
