/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.domain.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author edcracken
 */
@Entity
@Table(name = "registro_laboral", catalog = "rrhh", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RegistroLaboral.findAll", query = "SELECT r FROM RegistroLaboral r")})
public class RegistroLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Column(name = "anio_ingreso")
    private Integer anioIngreso;
    @Column(length = 50)
    private String expectativa;
    @Column(name = "calificacion_servicio")
    private Integer calificacionServicio;
    private Boolean comisionado;
    @Column(length = 50)
    private String estado;
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
    @OneToMany(mappedBy = "fkRegistroLaboral")
    private Collection<Puesto> puestoCollection;
    @JoinColumn(name = "fk_distrito_comisionado", referencedColumnName = "codigo")
    @ManyToOne
    private Distrito fkDistritoComisionado;
    @JoinColumn(name = "fk_lugar_especifico_comisionado", referencedColumnName = "codigo")
    @ManyToOne
    private LugarEspecifico fkLugarEspecificoComisionado;
    @JoinColumn(name = "fk_persona", referencedColumnName = "cui")
    @ManyToOne
    private Persona fkPersona;
    @JoinColumn(name = "fk_unidad_ejecutora_comisionado", referencedColumnName = "codigo")
    @ManyToOne
    private UnidadEjecutora fkUnidadEjecutoraComisionado;

    public RegistroLaboral() {
    }

    public RegistroLaboral(Integer codigo) {
        this.codigo = codigo;
    }

    public RegistroLaboral(Integer codigo, Date fechaCreacion, Date fechaUltimoCambio) {
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

    public Integer getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(Integer anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String getExpectativa() {
        return expectativa;
    }

    public void setExpectativa(String expectativa) {
        this.expectativa = expectativa;
    }

    public Integer getCalificacionServicio() {
        return calificacionServicio;
    }

    public void setCalificacionServicio(Integer calificacionServicio) {
        this.calificacionServicio = calificacionServicio;
    }

    public Boolean getComisionado() {
        return comisionado;
    }

    public void setComisionado(Boolean comisionado) {
        this.comisionado = comisionado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Collection<Puesto> getPuestoCollection() {
        return puestoCollection;
    }

    public void setPuestoCollection(Collection<Puesto> puestoCollection) {
        this.puestoCollection = puestoCollection;
    }

    public Distrito getFkDistritoComisionado() {
        return fkDistritoComisionado;
    }

    public void setFkDistritoComisionado(Distrito fkDistritoComisionado) {
        this.fkDistritoComisionado = fkDistritoComisionado;
    }

    public LugarEspecifico getFkLugarEspecificoComisionado() {
        return fkLugarEspecificoComisionado;
    }

    public void setFkLugarEspecificoComisionado(LugarEspecifico fkLugarEspecificoComisionado) {
        this.fkLugarEspecificoComisionado = fkLugarEspecificoComisionado;
    }

    public Persona getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Persona fkPersona) {
        this.fkPersona = fkPersona;
    }

    public UnidadEjecutora getFkUnidadEjecutoraComisionado() {
        return fkUnidadEjecutoraComisionado;
    }

    public void setFkUnidadEjecutoraComisionado(UnidadEjecutora fkUnidadEjecutoraComisionado) {
        this.fkUnidadEjecutoraComisionado = fkUnidadEjecutoraComisionado;
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
        if (!(object instanceof RegistroLaboral)) {
            return false;
        }
        RegistroLaboral other = (RegistroLaboral) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ms.rrhh.domain.model.RegistroLaboral[ codigo=" + codigo + " ]";
    }
    
}
