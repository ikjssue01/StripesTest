/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.dao;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashMultiset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import org.ms.rrhh.api.dao.impl.CrudRepositoryImpl;
import org.ms.rrhh.domain.enums.CampoBusquedaAvanzada;
import org.ms.rrhh.domain.enums.ComparadorBusqueda;
import org.ms.rrhh.domain.enums.EstadoVariable;
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
        CriteriaQuery<Persona> cQueryPersona = cb.createQuery(Persona.class);
        Root<Persona> rootPersona = cQueryPersona.from(Persona.class);
        EntityType<Persona> type = getEntityManager().getMetamodel().entity(Persona.class);
        List<Predicate> criteria = new ArrayList<Predicate>();
        if (normal.getPrimerNombre() != null) {
            criteria.add(cb.like(rootPersona.get(type.getSingularAttribute("primerNombre", String.class)),
                    likeExpr(normal.getPrimerNombre())));
        }
        if (normal.getSegundoNombre() != null) {
            criteria.add(cb.like(rootPersona.get(type.getSingularAttribute("segundoNombre", String.class)),
                    likeExpr(normal.getSegundoNombre())));
        }
        if (normal.getPrimerApellido() != null) {
            criteria.add(cb.like(rootPersona.get(type.getSingularAttribute("primerApellido", String.class)),
                    likeExpr(normal.getPrimerNombre())));
        }
        if (normal.getSegundoApellido() != null) {
            criteria.add(cb.like(rootPersona.get(type.getSingularAttribute("segundoApellido", String.class)),
                    likeExpr(normal.getPrimerApellido())));
        }
        if (normal.getSexo() != null) {
            criteria.add(cb.equal(rootPersona.get(type.getSingularAttribute("sexo", Sexo.class)),
                    normal.getSexo()));
        }
        if (normal.getFechaNacInicio() != null) {
            criteria.add(cb.greaterThanOrEqualTo(rootPersona.get(type.getSingularAttribute("fechaNacimiento", Date.class)),
                    normal.getFechaNacInicio()));
        }
        if (normal.getFechaNacFin() != null) {
            criteria.add(cb.lessThanOrEqualTo(rootPersona.get(type.getSingularAttribute("fechaNacimiento", Date.class)),
                    normal.getFechaNacFin()));
        }
        if (normal.getEdad() != null && normal.getEdad() >= 0) {
            criteria.add(cb.equal(rootPersona.get(type.getSingularAttribute("edad", Integer.class)),
                    normal.getEdad()));
        }
        cQueryPersona.where(cb.or(criteria.toArray(new Predicate[criteria.size()])));

        List<Persona> r1 = getEntityManager()
                .createQuery(cQueryPersona).getResultList();
        if (normal.getDireccion() != null || normal.getMunicipio() != null) {
            CriteriaQuery<LugarResidencia> cLugar = cb.createQuery(LugarResidencia.class);
            Root<LugarResidencia> lugarResidencia = cLugar.from(LugarResidencia.class);
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
            cLugar.where(cb.and(cb.equal(
                    lugarResidencia.get(residenciaType.getSingularAttribute("estado", EstadoVariable.class)),
                    EstadoVariable.ACTUAL), cb.or(criteriaLugar.toArray(new Predicate[criteriaLugar.size()]))));

            r1.addAll(Collections2.transform(getEntityManager().createQuery(cLugar).getResultList(),
                    new Function<LugarResidencia, Persona>() {
                @Override
                public Persona apply(LugarResidencia f) {
                    return f.getFkPersona();
                }
            }
            ));
        }

        return new ArrayList(HashMultiset.create(r1).elementSet());
    }

    private String likeExpr(String val) {
        return "%".concat(val).concat("%");
    }

    /**
     *
     * @param tipo
     * @return
     */
    private Class getClassTipo(TipoCampoBusqueda tipo) {
        if (tipo.equals(TipoCampoBusqueda.TEXTO)) {
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

        if (clazz.equals(Date.class
        )) {
            try {
                return sd.parse(value);

            } catch (ParseException ex) {
                Logger.getLogger(PersonasDaoImpl.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        }
        if (clazz.equals(Integer.class
        )) {
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

        if (clazz.equals(Date.class
        )) {
            return cb.between((Expression<Date>) ex,
                    (Date) getValueByClass(clazz, value1),
                    (Date) getValueByClass(clazz, value2));

        }
        return cb.between((Expression<Integer>) ex,
                (Integer) getValueByClass(clazz, value1),
                (Integer) getValueByClass(clazz, value2));

    }

    private StringBuffer getEntreCriteria(FiltroAvanzadoDto fa, StringBuffer q) {
        if (fa.getTipoDato().equals(TipoCampoBusqueda.NUMERO)) {
            return q
                    .append(fa.getCampo().getValue())
                    .append(" between ")
                    .append(fa.getValor1())
                    .append(" and ")
                    .append(fa.getValor1());
        }

        if (fa.getTipoDato().equals(TipoCampoBusqueda.FECHA)) {
            return q
                    .append(fa.getCampo().getValue())
                    .append(" between ")
                    .append("'")
                    .append(fa.getValor1())
                    .append("'")
                    .append(" and ")
                    .append("'")
                    .append(fa.getValor2())
                    .append("'");
        }
        return null;
    }

    /**
     *
     * @param normal
     * @return
     * @throws DataAccessException
     */
    @Override
    public List<Persona> busquedaAvanzada(BusquedaAvanzadaDto normal) throws DataAccessException {
        StringBuffer pLaboralByTipoPuestos = new StringBuffer("Select rl.fkPersona from RegistroLaboral rl")
                .append(" where ")
                .append("rl in(select p.fkRegistroLaboral form Puesto p "
                        + " where p.fkPuestoNominal IN :puestos ");

        StringBuffer puestosByRenglon = new StringBuffer("select pp.id from Puestos pp where c.codigoPadre=NULL and ");
        for (FiltroAvanzadoDto fa : normal.getFiltros()) {
            if (fa.getCampo().equals(CampoBusquedaAvanzada.REGLON)) {
                if (fa.getComparador().equals(ComparadorBusqueda.ENTRE)) {
                    puestosByRenglon = getEntreCriteria(fa, puestosByRenglon);
                }
            }
        }

//        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
//        CriteriaQuery<Persona> cPersona = cb.createQuery(Persona.class
//        );
//        Root<Persona> rootPersona = cPersona.from(Persona.class
//        );
//        EntityType<Persona> typePersona = getEntityManager().getMetamodel().entity(Persona.class
//        );
//
//        CriteriaQuery<Puesto> c = cb.createQuery(Puesto.class
//        );
//        Root<Puesto> root = c.from(Puesto.class);
//        EntityType<Puesto> type = getEntityManager()
//                .getMetamodel()
//                .entity(Puesto.class);
//
//        List<Predicate> criteria = new ArrayList<Predicate>();
//        for (FiltroAvanzadoDto f : normal.getFiltros()) {
//            if (f.getComparador().equals(ComparadorBusqueda.IGUAL)) {
//                Class tipo;
//                criteria.add(cb.equal(root.get(type
//                        .getSingularAttribute(f.getCampo(), tipo = getClassTipo(f.getTipoDato()))),
//                        getValueByClass(tipo, f.getValor1())));
//            }
//            if (f.getComparador().equals(ComparadorBusqueda.DIFERENTE)) {
//                Class tipo;
//                criteria.add(cb.notEqual(root.get(type
//                        .getSingularAttribute(f.getCampo(), tipo = getClassTipo(f.getTipoDato()))),
//                        getValueByClass(tipo, f.getValor1())));
//            }
//            if (f.getComparador().equals(ComparadorBusqueda.ENTRE)) {
//                Class tipo = getClassTipo(f.getTipoDato());
//                criteria.add(getPredicateBetweenByClass(root.get(type
//                        .getSingularAttribute(f.getCampo().toLowerCase(), tipo)), tipo,
//                        f.getValor1(),
//                        f.getValor2()));
//            }
//        }
//        c.where(cb.or(criteria.toArray(new Predicate[criteria.size()])));
        return null; //getEntityManager().createQuery(c).getResultList();
    }

}
