/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.api;

import java.io.Serializable;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author eliud
 * @param <T>
 */
public interface BaseDao<T> {

    public void save(T entity) throws DataAccessException;

    public void update(T entity) throws DataAccessException;

    public void delete(T entity) throws DataAccessException;

    public T getOne(Serializable id) throws DataAccessException;

    public List<T> getAll() throws DataAccessException;
}
