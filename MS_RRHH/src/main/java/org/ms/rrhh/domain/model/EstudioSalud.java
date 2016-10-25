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
@Table(name = "estudio_salud", catalog = "rrhh", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EstudioSalud.findAll", query = "SELECT e FROM EstudioSalud e")})
public class EstudioSalud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Column(name = "anio_estudio")
    private Integer anioEstudio;
    @Column(name = "grado_actual", length = 50)
    private String gradoActual;
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
    @JoinColumn(name = "fk_persona", referencedColumnName = "cui")
    @ManyToOne
    private Persona fkPersona;

    public EstudioSalud() {
    }

    public EstudioSalud(Integer codigo) {
        this.codigo = codigo;
    }

    public EstudioSalud(Integer codigo, Date fechaCreacion, Date fechaUltimoCambio) {
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

    public Integer getAnioEstudio() {
        return anioEstudio;
    }

    public void setAnioEstudio(Integer anioEstudio) {
        this.anioEstudio = anioEstudio;
    }

    public String getGradoActual() {
        return gradoActual;
    }

    public void setGradoActual(String gradoActual) {
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

    public Persona getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Persona fkPersona) {
        this.fkPersona = fkPersona;
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
        if (!(object instanceof EstudioSalud)) {
            return false;
        }
        EstudioSalud other = (EstudioSalud) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ms.rrhh.domain.model.EstudioSalud[ codigo=" + codigo + " ]";
    }
    
}
