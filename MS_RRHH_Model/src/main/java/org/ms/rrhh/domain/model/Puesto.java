/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.domain.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author edcracken
 */
@Entity
@Table(catalog = "rrhh", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Puesto.findAll", query = "SELECT p FROM Puesto p")})
public class Puesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Column(name = "puesto_funcional", length = 50)
    private String puestoFuncional;
    @Column(length = 50)
    private String tipo;
    @Basic(optional = false)
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "creado_por", length = 50)
    private String creadoPor;
    @Basic(optional = false)
    @Column(name = "fecha_ultimo_cambio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoCambio;
    @Column(name = "ultimo_cambio_por", length = 50)
    private String ultimoCambioPor;
    @JoinColumn(name = "fk_distrito", referencedColumnName = "codigo")
    @ManyToOne
    private Distrito fkDistrito;
    @JoinColumn(name = "fk_lugar_especifico", referencedColumnName = "codigo")
    @ManyToOne
    private LugarEspecifico fkLugarEspecifico;
    @JoinColumn(name = "fk_puesto_nominal", referencedColumnName = "codigo")
    @ManyToOne
    private PuestoNominal fkPuestoNominal;
    @JoinColumn(name = "fk_registro_laboral", referencedColumnName = "codigo")
    @ManyToOne
    private RegistroLaboral fkRegistroLaboral;
    @JoinColumn(name = "fk_renglon", referencedColumnName = "codigo")
    @ManyToOne
    private RenglonPresupuesto fkRenglon;
    @JoinColumn(name = "fk_unidad_ejecutora", referencedColumnName = "codigo")
    @ManyToOne
    private UnidadEjecutora fkUnidadEjecutora;

    public Puesto() {
    }

    public Puesto(Integer codigo) {
        this.codigo = codigo;
    }

    public Puesto(Integer codigo, Date fechaCreacion, Date fechaUltimoCambio) {
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimoCambio = fechaUltimoCambio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPuestoFuncional() {
        return puestoFuncional;
    }

    public void setPuestoFuncional(String puestoFuncional) {
        this.puestoFuncional = puestoFuncional;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Date getFechaUltimoCambio() {
        return fechaUltimoCambio;
    }

    public void setFechaUltimoCambio(Date fechaUltimoCambio) {
        this.fechaUltimoCambio = fechaUltimoCambio;
    }

    public String getUltimoCambioPor() {
        return ultimoCambioPor;
    }

    public void setUltimoCambioPor(String ultimoCambioPor) {
        this.ultimoCambioPor = ultimoCambioPor;
    }

    public Distrito getFkDistrito() {
        return fkDistrito;
    }

    public void setFkDistrito(Distrito fkDistrito) {
        this.fkDistrito = fkDistrito;
    }

    public LugarEspecifico getFkLugarEspecifico() {
        return fkLugarEspecifico;
    }

    public void setFkLugarEspecifico(LugarEspecifico fkLugarEspecifico) {
        this.fkLugarEspecifico = fkLugarEspecifico;
    }

    public PuestoNominal getFkPuestoNominal() {
        return fkPuestoNominal;
    }

    public void setFkPuestoNominal(PuestoNominal fkPuestoNominal) {
        this.fkPuestoNominal = fkPuestoNominal;
    }

    public RegistroLaboral getFkRegistroLaboral() {
        return fkRegistroLaboral;
    }

    public void setFkRegistroLaboral(RegistroLaboral fkRegistroLaboral) {
        this.fkRegistroLaboral = fkRegistroLaboral;
    }

    public RenglonPresupuesto getFkRenglon() {
        return fkRenglon;
    }

    public void setFkRenglon(RenglonPresupuesto fkRenglon) {
        this.fkRenglon = fkRenglon;
    }

    public UnidadEjecutora getFkUnidadEjecutora() {
        return fkUnidadEjecutora;
    }

    public void setFkUnidadEjecutora(UnidadEjecutora fkUnidadEjecutora) {
        this.fkUnidadEjecutora = fkUnidadEjecutora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ms.rrhh.domain.model.Puesto[ codigo=" + codigo + " ]";
    }
    
}
