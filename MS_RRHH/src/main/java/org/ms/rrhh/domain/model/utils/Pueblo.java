package org.ms.rrhh.domain.model.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edcracken
 */
public enum Pueblo {

    MESTIZO_O_LADINO("ladino"),
    MAYA("maya"),
    GARIFUNA("garifuna"),
    XINCA("xinca"),
    OTRO("otro"),
    NO_INDICA("no_indica");

    private String value;

    private Pueblo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
