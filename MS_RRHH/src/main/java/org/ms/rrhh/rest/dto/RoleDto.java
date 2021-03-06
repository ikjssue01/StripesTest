/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.dto;

import java.util.List;

/**
 *
 * @author eliud
 */
public class RoleDto {

    private Integer id;
    private String nombre;
    private List<AccesoDto> accesos;
    private String usuario;

    public RoleDto() {
    }

    public RoleDto(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AccesoDto> getAccesos() {
        return accesos;
    }

    public void setAccesos(List<AccesoDto> accesos) {
        this.accesos = accesos;
    }

}
