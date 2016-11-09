/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.dto;

import gt.org.isis.model.enums.TipoPuesto;

/**
 *
 * @author eliud
 */
public class RegistroLaboralPuestoDto {

    private Integer fkPuestoFuncional;
    private TipoPuesto tipo;
    private Integer fkPuestoNominal;
    private Integer fkComunidad;
    private Integer fkClasificacionServicio;

    public Integer getFkPuestoFuncional() {
        return fkPuestoFuncional;
    }

    public void setFkPuestoFuncional(Integer fkPuestoFuncional) {
        this.fkPuestoFuncional = fkPuestoFuncional;
    }

    public TipoPuesto getTipo() {
        return tipo;
    }

    public void setTipo(TipoPuesto tipo) {
        this.tipo = tipo;
    }

    public Integer getFkPuestoNominal() {
        return fkPuestoNominal;
    }

    public void setFkPuestoNominal(Integer fkPuestoNominal) {
        this.fkPuestoNominal = fkPuestoNominal;
    }

    public Integer getFkComunidad() {
        return fkComunidad;
    }

    public void setFkComunidad(Integer fkComunidad) {
        this.fkComunidad = fkComunidad;
    }

    public Integer getFkClasificacionServicio() {
        return fkClasificacionServicio;
    }

    public void setFkClasificacionServicio(Integer fkClasificacionServicio) {
        this.fkClasificacionServicio = fkClasificacionServicio;
    }

}
