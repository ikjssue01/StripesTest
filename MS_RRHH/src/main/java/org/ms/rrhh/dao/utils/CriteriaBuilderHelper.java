/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.dao.utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;

/**
 *
 * @author edcracken
 */
public class CriteriaBuilderHelper {

    private static final String SOUNDEX = "soundex";

    /**
     *
     * @param cb
     * @param exp
     * @return
     */
    public static Expression<String> functionSoundexName(CriteriaBuilder cb, Expression<String> exp) {
        return cb.function(
                SOUNDEX,
                String.class,
                cb.lower(exp)
        );
    }

    public static Expression<String> functionSoundexValue(CriteriaBuilder cb, String value) {
        return cb.function(
                SOUNDEX,
                String.class,
                cb.lower(cb.literal(value))
        );
    }
}
