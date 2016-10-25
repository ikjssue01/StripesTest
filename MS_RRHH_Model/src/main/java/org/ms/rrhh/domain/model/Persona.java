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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(catalog = "rrhh", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String cui;
    @Basic(optional = false)
    @Column(name = "primer_nombre", nullable = false, length = 100)
    private String primerNombre;
    @Column(name = "segundo_nombre", length = 100)
    private String segundoNombre;
    @Column(name = "tercer_nombre", length = 100)
    private String tercerNombre;
    @Column(name = "otros_nombres", length = 2147483647)
    private String otrosNombres;
    @Basic(optional = false)
    @Column(name = "primer_apellido", nullable = false, length = 100)
    private String primerApellido;
    @Column(name = "segundo_apellido", length = 100)
    private String segundoApellido;
    @Column(name = "tercer_apellido", length = 100)
    private String tercerApellido;
    @Column(name = "otros_apellidos", length = 2147483647)
    private String otrosApellidos;
    @Column(name = "apellido_casada", length = 100)
    private String apellidoCasada;
    @Column(name = "estado_civil", length = 50)
    private String estadoCivil;
    @Column(length = 50)
    private String sexo;
    @Column(length = 50)
    private String nacionalidad;
    @Column(length = 50)
    private String profesion;
    @Column(name = "limitaciones_fisicas", length = 2147483647)
    private String limitacionesFisicas;
    @Column(name = "sabe_leer")
    private Boolean sabeLeer;
    @Column(name = "sabe_escribir")
    private Boolean sabeEscribir;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "nac_no_libro", length = 50)
    private String nacNoLibro;
    @Column(name = "nac_no_folio", length = 50)
    private String nacNoFolio;
    @Column(name = "nac_no_partida", length = 50)
    private String nacNoPartida;
    @Column(name = "fk_pueblo")
    private Integer fkPueblo;
    @Column(name = "fk_comunidad_linguistica")
    private Integer fkComunidadLinguistica;
    @Column(length = 2147483647)
    private String idiomas;
    @Column(length = 2147483647)
    private String mrz;
    @Column(name = "no_cedula", length = 50)
    private String noCedula;
    @Column(length = 50)
    private String estado;
    @Column(name = "huella_mano", length = 50)
    private String huellaMano;
    @Column(name = "huella_dedo", length = 50)
    private String huellaDedo;
    @Basic(optional = false)
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "creado_por", nullable = false, length = 50)
    private String creadoPor;
    @JoinColumn(name = "fk_municipio_cedula", referencedColumnName = "codigo")
    @ManyToOne
    private Municipio fkMunicipioCedula;
    @JoinColumn(name = "fk_municipio_nacimiento", referencedColumnName = "codigo")
    @ManyToOne
    private Municipio fkMunicipioNacimiento;
    @JoinColumn(name = "fk_municipio_vecindad", referencedColumnName = "codigo")
    @ManyToOne
    private Municipio fkMunicipioVecindad;
    @OneToMany(mappedBy = "fkPersona")
    private Collection<RegistroAcademico> registroAcademicoCollection;
    @OneToMany(mappedBy = "fkPersona")
    private Collection<HistoricoPersona> historicoPersonaCollection;
    @OneToMany(mappedBy = "fkPersona")
    private Collection<EstudioSalud> estudioSaludCollection;
    @OneToMany(mappedBy = "fkPersona")
    private Collection<RegistroLaboral> registroLaboralCollection;
    @OneToMany(mappedBy = "fkPersona")
    private Collection<LugarResidencia> lugarResidenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPersona")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "fkPersona")
    private Collection<Dpi> dpiCollection;

    public Persona() {
    }

    public Persona(String cui) {
        this.cui = cui;
    }

    public Persona(String cui, String primerNombre, String primerApellido, Date fechaNacimiento, Date fechaCreacion, String creadoPor) {
        this.cui = cui;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
        this.creadoPor = creadoPor;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getOtrosNombres() {
        return otrosNombres;
    }

    public void setOtrosNombres(String otrosNombres) {
        this.otrosNombres = otrosNombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTercerApellido() {
        return tercerApellido;
    }

    public void setTercerApellido(String tercerApellido) {
        this.tercerApellido = tercerApellido;
    }

    public String getOtrosApellidos() {
        return otrosApellidos;
    }

    public void setOtrosApellidos(String otrosApellidos) {
        this.otrosApellidos = otrosApellidos;
    }

    public String getApellidoCasada() {
        return apellidoCasada;
    }

    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getLimitacionesFisicas() {
        return limitacionesFisicas;
    }

    public void setLimitacionesFisicas(String limitacionesFisicas) {
        this.limitacionesFisicas = limitacionesFisicas;
    }

    public Boolean getSabeLeer() {
        return sabeLeer;
    }

    public void setSabeLeer(Boolean sabeLeer) {
        this.sabeLeer = sabeLeer;
    }

    public Boolean getSabeEscribir() {
        return sabeEscribir;
    }

    public void setSabeEscribir(Boolean sabeEscribir) {
        this.sabeEscribir = sabeEscribir;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacNoLibro() {
        return nacNoLibro;
    }

    public void setNacNoLibro(String nacNoLibro) {
        this.nacNoLibro = nacNoLibro;
    }

    public String getNacNoFolio() {
        return nacNoFolio;
    }

    public void setNacNoFolio(String nacNoFolio) {
        this.nacNoFolio = nacNoFolio;
    }

    public String getNacNoPartida() {
        return nacNoPartida;
    }

    public void setNacNoPartida(String nacNoPartida) {
        this.nacNoPartida = nacNoPartida;
    }

    public Integer getFkPueblo() {
        return fkPueblo;
    }

    public void setFkPueblo(Integer fkPueblo) {
        this.fkPueblo = fkPueblo;
    }

    public Integer getFkComunidadLinguistica() {
        return fkComunidadLinguistica;
    }

    public void setFkComunidadLinguistica(Integer fkComunidadLinguistica) {
        this.fkComunidadLinguistica = fkComunidadLinguistica;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getMrz() {
        return mrz;
    }

    public void setMrz(String mrz) {
        this.mrz = mrz;
    }

    public String getNoCedula() {
        return noCedula;
    }

    public void setNoCedula(String noCedula) {
        this.noCedula = noCedula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHuellaMano() {
        return huellaMano;
    }

    public void setHuellaMano(String huellaMano) {
        this.huellaMano = huellaMano;
    }

    public String getHuellaDedo() {
        return huellaDedo;
    }

    public void setHuellaDedo(String huellaDedo) {
        this.huellaDedo = huellaDedo;
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

    public Municipio getFkMunicipioCedula() {
        return fkMunicipioCedula;
    }

    public void setFkMunicipioCedula(Municipio fkMunicipioCedula) {
        this.fkMunicipioCedula = fkMunicipioCedula;
    }

    public Municipio getFkMunicipioNacimiento() {
        return fkMunicipioNacimiento;
    }

    public void setFkMunicipioNacimiento(Municipio fkMunicipioNacimiento) {
        this.fkMunicipioNacimiento = fkMunicipioNacimiento;
    }

    public Municipio getFkMunicipioVecindad() {
        return fkMunicipioVecindad;
    }

    public void setFkMunicipioVecindad(Municipio fkMunicipioVecindad) {
        this.fkMunicipioVecindad = fkMunicipioVecindad;
    }

    public Collection<RegistroAcademico> getRegistroAcademicoCollection() {
        return registroAcademicoCollection;
    }

    public void setRegistroAcademicoCollection(Collection<RegistroAcademico> registroAcademicoCollection) {
        this.registroAcademicoCollection = registroAcademicoCollection;
    }

    public Collection<HistoricoPersona> getHistoricoPersonaCollection() {
        return historicoPersonaCollection;
    }

    public void setHistoricoPersonaCollection(Collection<HistoricoPersona> historicoPersonaCollection) {
        this.historicoPersonaCollection = historicoPersonaCollection;
    }

    public Collection<EstudioSalud> getEstudioSaludCollection() {
        return estudioSaludCollection;
    }

    public void setEstudioSaludCollection(Collection<EstudioSalud> estudioSaludCollection) {
        this.estudioSaludCollection = estudioSaludCollection;
    }

    public Collection<RegistroLaboral> getRegistroLaboralCollection() {
        return registroLaboralCollection;
    }

    public void setRegistroLaboralCollection(Collection<RegistroLaboral> registroLaboralCollection) {
        this.registroLaboralCollection = registroLaboralCollection;
    }

    public Collection<LugarResidencia> getLugarResidenciaCollection() {
        return lugarResidenciaCollection;
    }

    public void setLugarResidenciaCollection(Collection<LugarResidencia> lugarResidenciaCollection) {
        this.lugarResidenciaCollection = lugarResidenciaCollection;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Collection<Dpi> getDpiCollection() {
        return dpiCollection;
    }

    public void setDpiCollection(Collection<Dpi> dpiCollection) {
        this.dpiCollection = dpiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cui != null ? cui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.cui == null && other.cui != null) || (this.cui != null && !this.cui.equals(other.cui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ms.rrhh.domain.model.Persona[ cui=" + cui + " ]";
    }
    
}
