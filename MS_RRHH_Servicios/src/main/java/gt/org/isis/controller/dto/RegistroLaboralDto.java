/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.dto;

/**
 *
 * @author eliud
 */
public class RegistroLaboralDto {

    private Integer id;
    private Integer anioIngreso;
    private Integer fkExpectativa;
    private String descripcionExpectativa;
    private Integer fkCalificacionServicio;
    private String descripcionCalificacionServicio;
    private Boolean comisionado;
    private Integer fkComunidadComisionado;

    public String getDescripcionExpectativa() {
        return descripcionExpectativa;
    }

    public void setDescripcionExpectativa(String descripcionExpectativa) {
        this.descripcionExpectativa = descripcionExpectativa;
    }

    public String getDescripcionCalificacionServicio() {
        return descripcionCalificacionServicio;
    }

    public void setDescripcionCalificacionServicio(String descripcionCalificacionServicio) {
        this.descripcionCalificacionServicio = descripcionCalificacionServicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(Integer anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public Integer getFkExpectativa() {
        return fkExpectativa;
    }

    public void setFkExpectativa(Integer fkExpectativa) {
        this.fkExpectativa = fkExpectativa;
    }

    public Integer getFkCalificacionServicio() {
        return fkCalificacionServicio;
    }

    public void setFkCalificacionServicio(Integer fkCalificacionServicio) {
        this.fkCalificacionServicio = fkCalificacionServicio;
    }

    public Boolean getComisionado() {
        return comisionado;
    }

    public void setComisionado(Boolean comisionado) {
        this.comisionado = comisionado;
    }

    public Integer getFkComunidadComisionado() {
        return fkComunidadComisionado;
    }

    public void setFkComunidadComisionado(Integer fkComunidadComisionado) {
        this.fkComunidadComisionado = fkComunidadComisionado;
    }

}
