/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.usuarios.handlers;

import gt.org.isis.api.AbstractRequestHandler;
import gt.org.isis.controller.dto.UsuarioDto;
import gt.org.isis.converters.UsuarioDtoConverter;
import gt.org.isis.model.Persona;
import gt.org.isis.model.Role;
import gt.org.isis.model.Usuario;
import gt.org.isis.repository.PersonasRepository;
import gt.org.isis.repository.RolesRepository;
import gt.org.isis.repository.UsuariosRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 *
 * @author edcracken
 */
@Service
public class ModificarUsHandler extends AbstractRequestHandler<UsuarioDto, UsuarioDto> {

    @Autowired
    RolesRepository roles;
    @Autowired
    UsuariosRepository usuarios;
    @Autowired
    PersonasRepository personas;

    @Override
    public UsuarioDto execute(final UsuarioDto request) {
        List<Usuario> ls = usuarios.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.like(root.get("id"), request.getUsuario());
            }
        });
        if (!ls.isEmpty()) {
            Usuario r = ls.get(0); //usuarios.findOne(request.getUsuario());
            Persona p = personas.findOne(request.getCui());
            Role rr = roles.findOne(request.getRoleId());
            UsuarioDtoConverter bc = new UsuarioDtoConverter();
            r.setClave(new String(DigestUtils.md5Digest(request.getClave().getBytes())));
//            r.setFkPersona(p);
            r.setFkRole(rr);

            usuarios.save(r);
            return bc.toDTO(r);
        } else {
            throw new RuntimeException("user not found!");
        }
    }

}
