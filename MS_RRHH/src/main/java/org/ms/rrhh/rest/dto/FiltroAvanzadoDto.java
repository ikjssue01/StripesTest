/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.dto;

import org.ms.rrhh.domain.enums.ComparadorBusqueda;
import org.ms.rrhh.domain.enums.TipoCampoBusqueda;

/**
 *
 * @author edcracken
 */
public class FiltroAvanzadoDto {

    private String campo;
    private ComparadorBusqueda comparador;
    private TipoCampoBusqueda tipoDato;
    private String valor1;
    private String valor2;

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    public TipoCampoBusqueda getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(TipoCampoBusqueda tipoDato) {
        this.tipoDato = tipoDato;
    }

    public ComparadorBusqueda getComparador() {
        return comparador;
    }

    public void setComparador(ComparadorBusqueda comparador) {
        this.comparador = comparador;
    }

}
