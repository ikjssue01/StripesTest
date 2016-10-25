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
@Table(name = "puesto_nominal", catalog = "rrhh", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PuestoNominal.findAll", query = "SELECT p FROM PuestoNominal p")})
public class PuestoNominal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Column(length = 100)
    private String nombre;
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
    @JoinColumn(name = "fk_renglon", referencedColumnName = "codigo")
    @ManyToOne
    private RenglonPresupuesto fkRenglon;
    @OneToMany(mappedBy = "fkPuestoNominal")
    private Collection<Puesto> puestoCollection;

    public PuestoNominal() {
    }

    public PuestoNominal(Integer codigo) {
        this.codigo = codigo;
    }

    public PuestoNominal(Integer codigo, Date fechaCreacion, Date fechaUltimoCambio) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public RenglonPresupuesto getFkRenglon() {
        return fkRenglon;
    }

    public void setFkRenglon(RenglonPresupuesto fkRenglon) {
        this.fkRenglon = fkRenglon;
    }

    public Collection<Puesto> getPuestoCollection() {
        return puestoCollection;
    }

    public void setPuestoCollection(Collection<Puesto> puestoCollection) {
        this.puestoCollection = puestoCollection;
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
        if (!(object instanceof PuestoNominal)) {
            return false;
        }
        PuestoNominal other = (PuestoNominal) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ms.rrhh.domain.model.PuestoNominal[ codigo=" + codigo + " ]";
    }
    
}