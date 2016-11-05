/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.dto;

/**
 *
 * @author edcracken
 */
public class BusquedaAvanzadaDto {

    private Integer unidadEjecutora;
    private Integer puestoNominal;
    private Integer renglon;
    private Integer clasificacionServicio;
    private Integer anioIngreso;

    public Integer getUnidadEjecutora() {
        return unidadEjecutora;
    }

    public void setUnidadEjecutora(Integer unidadEjecutora) {
        this.unidadEjecutora = unidadEjecutora;
    }

    public Integer getPuestoNominal() {
        return puestoNominal;
    }

    public void setPuestoNominal(Integer puestoNominal) {
        this.puestoNominal = puestoNominal;
    }

    public Integer getRenglon() {
        return renglon;
    }

    public void setRenglon(Integer renglon) {
        this.renglon = renglon;
    }

    public Integer getClasificacionServicio() {
        return clasificacionServicio;
    }

    public void setClasificacionServicio(Integer clasificacionServicio) {
        this.clasificacionServicio = clasificacionServicio;
    }

    public Integer getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(Integer anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

}
