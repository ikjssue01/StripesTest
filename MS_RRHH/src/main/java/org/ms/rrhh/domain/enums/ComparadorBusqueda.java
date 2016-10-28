package org.ms.rrhh.domain.enums;

import org.codehaus.jackson.annotate.JsonCreator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author edcracken
 */
public enum ComparadorBusqueda {

    IGUAL("igual"),
    DIFERENTE("diferente"),
    TODOS("todos"),
    ENTRE("entre");

    private String value;

    private ComparadorBusqueda(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ComparadorBusqueda forValue(String value) {
        return ComparadorBusqueda.valueOf(value);
    }
}
