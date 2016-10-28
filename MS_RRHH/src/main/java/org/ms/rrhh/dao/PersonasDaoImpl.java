/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.persistence.metamodel.EntityType;
import org.ms.rrhh.api.dao.impl.CrudRepositoryImpl;
import org.ms.rrhh.domain.enums.ComparadorBusqueda;
import org.ms.rrhh.domain.enums.Sexo;
import org.ms.rrhh.domain.enums.TipoCampoBusqueda;
import org.ms.rrhh.domain.model.LugarResidencia;
import org.ms.rrhh.domain.model.Persona;
import org.ms.rrhh.rest.dto.BusquedaAvanzadaDto;
import org.ms.rrhh.rest.dto.BusquedaNormalDto;
import org.ms.rrhh.rest.dto.FiltroAvanzadoDto;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author edcracken
 */
@Repository
public class PersonasDaoImpl extends CrudRepositoryImpl<Persona> implements PersonasDao {

    @Transactional
    @Override
    public List<Persona> busquedaNormal(BusquedaNormalDto normal) throws DataAccessException {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Persona> c = cb.createQuery(Persona.class);
        Root<Persona> root = c.from(Persona.class);
        EntityType<Persona> type = getEntityManager().getMetamodel().entity(Persona.class);
        Subquery<LugarResidencia> sqLugar = null;
        List<Predicate> criteria = new ArrayList<Predicate>();
        if (normal.getPrimerNombre() != null) {
            criteria.add(cb.like(root.get(type.getSingularAttribute("primerNombre", String.class)),
                    normal.getPrimerNombre()));
        }
        if (normal.getSegundoNombre() != null) {
            criteria.add(cb.like(root.get(type.getSingularAttribute("segundoNombre", String.class)),
                    normal.getSegundoNombre()));
        }
        if (normal.getPrimerApellido() != null) {
            criteria.add(cb.like(root.get(type.getSingularAttribute("primerApellido", String.class)),
                    normal.getPrimerNombre()));
        }
        if (normal.getSegundoApellido() != null) {
            criteria.add(cb.like(root.get(type.getSingularAttribute("segundoApellido", String.class)),
                    normal.getPrimerApellido()));
        }
        if (normal.getSexo() != null) {
            criteria.add(cb.equal(root.get(type.getSingularAttribute("sexo", Sexo.class)),
                    normal.getSexo()));
        }
        if (normal.getFechaNacInicio() != null) {
            criteria.add(cb.greaterThanOrEqualTo(root.get(type.getSingularAttribute("fechaNacimiento", Date.class)),
                    normal.getFechaNacInicio()));
        }
        if (normal.getFechaNacFin() != null) {
            criteria.add(cb.lessThanOrEqualTo(root.get(type.getSingularAttribute("fechaNacimiento", Date.class)),
                    normal.getFechaNacFin()));
        }
        if (normal.getEdad() != null && normal.getEdad() >= 0) {
            criteria.add(cb.equal(root.get(type.getSingularAttribute("edad", Integer.class)),
                    normal.getEdad()));
        }
        if (normal.getDireccion() != null || normal.getMunicipio() != null) {
            sqLugar = c.subquery(LugarResidencia.class);
            Root<LugarResidencia> lugarResidencia = sqLugar.from(LugarResidencia.class);
            List<Predicate> criteriaLugar = new ArrayList<Predicate>();
            EntityType<LugarResidencia> residenciaType = getEntityManager()
                    .getMetamodel()
                    .entity(LugarResidencia.class);
            if (normal.getDireccion() != null && !normal.getDireccion().isEmpty()) {
                criteriaLugar.add(cb.like(
                        lugarResidencia.get(residenciaType.getSingularAttribute("direccion", String.class)),
                        likeExpr(normal.getDireccion())
                ));
            }
            if (normal.getMunicipio() != null) {
                criteriaLugar.add(cb.equal(
                        lugarResidencia.get(residenciaType.getSingularAttribute("fkMunicipio", Integer.class)),
                        normal.getMunicipio()));
            }
            sqLugar.select(lugarResidencia)
                    .where(criteriaLugar.toArray(new Predicate[criteriaLugar.size()]));
        }

        if (sqLugar != null) {
            criteria.add(cb.in(sqLugar));
        }
        c.where(cb.or(criteria.toArray(new Predicate[criteria.size()])));

        return getEntityManager().createQuery(c).getResultList();
    }

    private String likeExpr(String val) {
        return "%".concat(val).concat("%");
    }

    @Transactional
    @Override
    public List<Persona> getAll() throws DataAccessException {
        Query query = getEntityManager().createQuery("select c from Persona c");
        List<Persona> resultList = query.getResultList();
        return resultList;
    }

    /**
     *
     * @param tipo
     * @return
     */
    private Class getClassTipo(TipoCampoBusqueda tipo) {
        if (tipo.equals(TipoCampoBusqueda.CARACTER)) {
            return String.class;
        }
        if (tipo.equals(TipoCampoBusqueda.NUMERO)) {
            return Integer.class;
        }
        if (tipo.equals(TipoCampoBusqueda.FECHA)) {
            return Date.class;
        }
        return Object.class;
    }

    /**
     *
     * @param clazz
     * @param value
     * @return
     */
    public Object getValueByClass(Class clazz, String value) {

        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        if (clazz.equals(Date.class)) {
            try {
                return sd.parse(value);
            } catch (ParseException ex) {
                Logger.getLogger(PersonasDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (clazz.equals(Integer.class)) {
            return Integer.valueOf(value);
        }

        return value;
    }

    /**
     *
     * @param ex
     * @param clazz
     * @param value1
     * @param value2
     * @return
     */
    public Predicate getPredicateBetweenByClass(Expression<?> ex, Class clazz, String value1, String value2) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        if (clazz.equals(Date.class)) {
            return cb.between((Expression<Date>) ex,
                    (Date) getValueByClass(clazz, value1),
                    (Date) getValueByClass(clazz, value2));

        }
        return cb.between((Expression<Integer>) ex,
                (Integer) getValueByClass(clazz, value1),
                (Integer) getValueByClass(clazz, value2));

    }

    /**
     *
     * @param normal
     * @return
     * @throws DataAccessException
     */
    @Override
    public List<Persona> busquedaAvanzada(BusquedaAvanzadaDto normal) throws DataAccessException {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Persona> c = cb.createQuery(Persona.class);
        Root<Persona> root = c.from(Persona.class);
        EntityType<Persona> type = getEntityManager().getMetamodel().entity(Persona.class);
        List<Predicate> criteria = new ArrayList<Predicate>();
        for (FiltroAvanzadoDto f : normal.getFiltros()) {
            if (f.getComparador().equals(ComparadorBusqueda.IGUAL)) {
                Class tipo;
                criteria.add(cb.equal(root.get(type
                        .getSingularAttribute(f.getCampo(), tipo = getClassTipo(f.getTipoDato()))),
                        getValueByClass(tipo, f.getValor1())));
            }
            if (f.getComparador().equals(ComparadorBusqueda.DIFERENTE)) {
                Class tipo;
                criteria.add(cb.notEqual(root.get(type
                        .getSingularAttribute(f.getCampo(), tipo = getClassTipo(f.getTipoDato()))),
                        getValueByClass(tipo, f.getValor1())));
            }
            if (f.getComparador().equals(ComparadorBusqueda.ENTRE)) {
                Class tipo = getClassTipo(f.getTipoDato());
                criteria.add(getPredicateBetweenByClass(root.get(type
                        .getSingularAttribute(f.getCampo(), tipo)), tipo,
                        f.getValor1(),
                        f.getValor2()));
            }
        }

        c.where(cb.or(criteria.toArray(new Predicate[criteria.size()])));

        return getEntityManager().createQuery(c).getResultList();
    }

}
