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
public enum CampoBusquedaAvanzada {

    UNIDAD_EJECUTORA("unidad_ejecutora"),
    PUESTO_NOMINAL("puesto_nominal"),
    REGLON("renglon"),
    CLASIFICACION_SERVICIO("clasificacion_servicio"),
    ANIO_INGRESO("anio_ingreso");

    private String value;

    private CampoBusquedaAvanzada(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonCreator
    public static CampoBusquedaAvanzada forValue(String value) {
        return CampoBusquedaAvanzada.valueOf(value);
    }

}
