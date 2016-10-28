/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.domain.utils;

import org.joda.time.DateTime;
import org.ms.rrhh.domain.model.CustomEntity;

/**
 *
 * @author eliud
 */
public class EntitiesHelper {

    public static void setDateCreateRef(CustomEntity ce) {
        ce.setFechaCreacion(new DateTime().toDate());
    }

    public static void setDateUpdateRef(CustomEntity ce) {
        ce.setFechaUltimoCambio(new DateTime().toDate());
    }

}
