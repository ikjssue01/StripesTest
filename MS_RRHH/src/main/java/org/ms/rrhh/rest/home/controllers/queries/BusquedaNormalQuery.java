/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.home.controllers.queries;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import org.ms.rrhh.api.QuerySpecification;
import org.ms.rrhh.domain.model.Persona;
import org.ms.rrhh.rest.dto.BusquedaNormalDto;

/**
 *
 * @author edcracken
 */
public class BusquedaNormalQuery implements QuerySpecification<Persona> {

    private BusquedaNormalDto normal;

    @Override
    public Predicate toPredicate(Root<Persona> root, CriteriaQuery<?> c, CriteriaBuilder cb,
            EntityType<Persona> type) {
//        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
//        CriteriaQuery<Persona> c = cb.createQuery(Persona.class);
//        Root<Persona> root = c.from(Persona.class);
//        EntityType<Persona> type = getEntityManager().getMetamodel().entity(Persona.class);

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
                    normal.getPrimerNombre()));
        }
        if (normal.getSexo() != null) {
            criteria.add(cb.like(root.get(type.getSingularAttribute("sexo", String.class)),
                    normal.getSexo().getValue()));
        }
        if (normal.getFechaNacInicio() != null) {
            criteria.add(cb.greaterThanOrEqualTo(root.get(type.getSingularAttribute("sexo", String.class)),
                    normal.getPrimerNombre()));
        }
        if (normal.getFechaNacFin() != null) {
            criteria.add(cb.lessThanOrEqualTo(root.get(type.getSingularAttribute("sexo", String.class)),
                    normal.getPrimerNombre()));
        }
        if (normal.getEdad() != null) {
            criteria.add(cb.equal(root.get(type.getSingularAttribute("sexo", String.class)),
                    normal.getPrimerNombre()));
        }
        if (normal.getDireccion() != null) {
            criteria.add(cb.like(root.get(type.getSingularAttribute("sexo", String.class)),
                    likeExpr(normal.getPrimerNombre())));
        }
        if (normal.getMunicipio() != null) {
            criteria.add(cb.equal(root.get(type.getSingularAttribute("sexo", String.class)),
                    likeExpr(normal.getPrimerNombre())));
        }
        c.where(cb.or(criteria.toArray(new Predicate[criteria.size()])));
    }

}
