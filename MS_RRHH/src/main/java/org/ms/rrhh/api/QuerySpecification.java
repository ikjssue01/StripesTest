/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.api;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

/**
 *
 * @author edcracken
 */
public interface QuerySpecification<T> {

    public Predicate toPredicate(Root<T> root,
            CriteriaQuery<?> query,
            CriteriaBuilder cb, EntityType<T> type);
}
