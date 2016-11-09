/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.dto;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eliud
 */
public class RegistroAcademicoDto {

    private Integer id;
    @NotNull
    private Integer ultimoGrado;
    private String nombreUltimoGrado;
    @NotNull
    private Boolean estudiaActualmente;
    @NotNull
    private Integer gradoActual;
    private String nombreGradoActual;
    private Date fechaCreacion;
    private String creadoPor;
    private List<RegistroAcademicoDto> historial;

    public String getNombreUltimoGrado() {
        return nombreUltimoGrado;
    }

    public void setNombreUltimoGrado(String nombreUltimoGrado) {
        this.nombreUltimoGrado = nombreUltimoGrado;
    }

    public String getNombreGradoActual() {
        return nombreGradoActual;
    }

    public void setNombreGradoActual(String nombreGradoActual) {
        this.nombreGradoActual = nombreGradoActual;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUltimoGrado() {
        return ultimoGrado;
    }

    public void setUltimoGrado(Integer ultimoGrado) {
        this.ultimoGrado = ultimoGrado;
    }

    public Boolean getEstudiaActualmente() {
        return estudiaActualmente;
    }

    public void setEstudiaActualmente(Boolean estudiaActualmente) {
        this.estudiaActualmente = estudiaActualmente;
    }

    public Integer getGradoActual() {
        return gradoActual;
    }

    public void setGradoActual(Integer gradoActual) {
        this.gradoActual = gradoActual;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public List<RegistroAcademicoDto> getHistorial() {
        return historial;
    }

    public void setHistorial(List<RegistroAcademicoDto> historial) {
        this.historial = historial;
    }

}
