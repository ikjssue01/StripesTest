package org.ms.rrhh.domain.enums;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edcracken
 */
public enum Sexo {

    HOMBRE("hombre"),
    MUJER("jumer");

    private String value;

    private Sexo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
