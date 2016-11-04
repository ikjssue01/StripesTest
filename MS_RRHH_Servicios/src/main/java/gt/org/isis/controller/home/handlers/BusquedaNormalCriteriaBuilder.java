/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.home.handlers;

import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author eliud
 */
public class BusquedaNormalCriteriaBuilder {

    private List<Predicate> criteria;
    private PersonaDto persona;
    private Root<Persona> root;
    private CriteriaQuery<?> cq;
    private CriteriaBuilder cb;

    public BusquedaNormalCriteriaBuilder withCq(CriteriaQuery cq) {
        this.cq = cq;
        return this;
    }

    public BusquedaNormalCriteriaBuilder withCB(CriteriaBuilder cq) {
        this.cb = cq;
        return this;
    }

    public BusquedaNormalCriteriaBuilder() {
        criteria = new ArrayList<Predicate>();
    }

    public static BusquedaNormalCriteriaBuilder get() {
        return new BusquedaNormalCriteriaBuilder();
    }

    public BusquedaNormalCriteriaBuilder withDto(PersonaDto filter) {
        this.persona = filter;
        return this;
    }

    public List<Predicate> build() {

    }
}
