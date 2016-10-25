/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.domain.model;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author edcracken
 */
@Entity
@Table(catalog = "rrhh", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String estado;
    @OneToMany(mappedBy = "fkMunicipioCedula")
    private Collection<Persona> personaCollection;
    @OneToMany(mappedBy = "fkMunicipioNacimiento")
    private Collection<Persona> personaCollection1;
    @OneToMany(mappedBy = "fkMunicipioVecindad")
    private Collection<Persona> personaCollection2;
    @JoinColumn(name = "fk_departamento", referencedColumnName = "codigo")
    @ManyToOne
    private Departamento fkDepartamento;
    @OneToMany(mappedBy = "fkMunicipio")
    private Collection<LugarResidencia> lugarResidenciaCollection;

    public Municipio() {
    }

    public Municipio(Integer codigo) {
        this.codigo = codigo;
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

    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    public Collection<Persona> getPersonaCollection1() {
        return personaCollection1;
    }

    public void setPersonaCollection1(Collection<Persona> personaCollection1) {
        this.personaCollection1 = personaCollection1;
    }

    public Collection<Persona> getPersonaCollection2() {
        return personaCollection2;
    }

    public void setPersonaCollection2(Collection<Persona> personaCollection2) {
        this.personaCollection2 = personaCollection2;
    }

    public Departamento getFkDepartamento() {
        return fkDepartamento;
    }

    public void setFkDepartamento(Departamento fkDepartamento) {
        this.fkDepartamento = fkDepartamento;
    }

    public Collection<LugarResidencia> getLugarResidenciaCollection() {
        return lugarResidenciaCollection;
    }

    public void setLugarResidenciaCollection(Collection<LugarResidencia> lugarResidenciaCollection) {
        this.lugarResidenciaCollection = lugarResidenciaCollection;
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
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ms.rrhh.domain.model.Municipio[ codigo=" + codigo + " ]";
    }
    
}
