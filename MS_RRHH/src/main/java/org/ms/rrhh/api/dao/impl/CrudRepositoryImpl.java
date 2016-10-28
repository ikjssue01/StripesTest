/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.api.dao.impl;

import org.ms.rrhh.api.BaseDaoImpl;
import org.ms.rrhh.domain.model.CustomEntity;

/**
 *
 * @author eliud
 * @param <T>
 */
public class CrudRepositoryImpl<T extends CustomEntity> extends BaseDaoImpl<T> implements CrudRepository<T> {

}
