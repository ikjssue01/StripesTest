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
@Table(name = "historico_persona", catalog = "rrhh", schema = "public")
@NamedQueries({
    @NamedQuery(name = "HistoricoPersona.findAll", query = "SELECT h FROM HistoricoPersona h")})
public class HistoricoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
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
    @Column(name = "fk_municipio_nacimiento")
    private Integer fkMunicipioNacimiento;
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
    @Column(name = "fk_municipio_cedula")
    private Integer fkMunicipioCedula;
    @Column(name = "fk_municipio_vecindad")
    private Integer fkMunicipioVecindad;
    @Column(name = "huella_mano", length = 50)
    private String huellaMano;
    @Column(name = "huella_dedo", length = 50)
    private String huellaDedo;
    @Basic(optional = false)
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "creado_por", length = 50)
    private String creadoPor;
    @JoinColumn(name = "fk_persona", referencedColumnName = "cui")
    @ManyToOne
    private Persona fkPersona;

    public HistoricoPersona() {
    }

    public HistoricoPersona(Integer codigo) {
        this.codigo = codigo;
    }

    public HistoricoPersona(Integer codigo, String primerNombre, String primerApellido, Date fechaNacimiento, Date fechaCreacion) {
        this.codigo = codigo;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public Integer getFkMunicipioNacimiento() {
        return fkMunicipioNacimiento;
    }

    public void setFkMunicipioNacimiento(Integer fkMunicipioNacimiento) {
        this.fkMunicipioNacimiento = fkMunicipioNacimiento;
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

    public Integer getFkMunicipioCedula() {
        return fkMunicipioCedula;
    }

    public void setFkMunicipioCedula(Integer fkMunicipioCedula) {
        this.fkMunicipioCedula = fkMunicipioCedula;
    }

    public Integer getFkMunicipioVecindad() {
        return fkMunicipioVecindad;
    }

    public void setFkMunicipioVecindad(Integer fkMunicipioVecindad) {
        this.fkMunicipioVecindad = fkMunicipioVecindad;
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
        if (!(object instanceof HistoricoPersona)) {
            return false;
        }
        HistoricoPersona other = (HistoricoPersona) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ms.rrhh.domain.model.HistoricoPersona[ codigo=" + codigo + " ]";
    }
    
}
