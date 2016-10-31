/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.catalogos.generales.handlers;

import gt.org.isis.api.SpecificationBuilder;
import gt.org.isis.controller.dto.CatalogosRequestDto;
import gt.org.isis.model.Catalogos;
import gt.org.isis.model.Catalogos_;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author eliud
 */
public class CatalogosSpec implements SpecificationBuilder<CatalogosRequestDto, Catalogos> {

    @Override
    public Specification<Catalogos> build(final CatalogosRequestDto param) {
        return new Specification<Catalogos>() {
            @Override
            public Predicate toPredicate(Root<Catalogos> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (param.getCodigoPadre() != null) {
                    predicates.add(cb.equal(root.get(Catalogos_.codigoPadre), param.getCodigoPadre()));
                }
                if (param.getTipo() != null) {
                    predicates.add(cb.equal(root.get(Catalogos_.tipo), param.getTipo()));
                }
                if (param.getValor() != null) {
                    predicates.add(cb.like(root.get(Catalogos_.valor),
                            param.getValor()));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
