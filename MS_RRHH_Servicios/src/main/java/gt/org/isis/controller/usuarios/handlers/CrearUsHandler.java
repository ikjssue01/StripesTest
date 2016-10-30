/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.usuarios.handlers;

import gt.org.isis.api.AbstractRequestHandler;
import gt.org.isis.controller.dto.UsuarioDto;
import gt.org.isis.model.Persona;
import gt.org.isis.model.Role;
import gt.org.isis.model.Usuario;
import gt.org.isis.model.utils.BeansConverter;
import gt.org.isis.repository.PersonasRepository;
import gt.org.isis.repository.RolesRepository;
import gt.org.isis.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 *
 * @author eliud
 */
@Component
public class CrearUsHandler extends AbstractRequestHandler<UsuarioDto, UsuarioDto> {

    @Autowired
    RolesRepository roles;
    @Autowired
    UsuariosRepository usuarios;
    @Autowired
    PersonasRepository personas;

    @Override
    public UsuarioDto execute(final UsuarioDto request) {
        Persona p = personas.findOne(request.getCui());
        Role rr = roles.findOne(request.getRoleId());
        BeansConverter<Usuario, UsuarioDto> bc;
        final Usuario r = (bc = new BeansConverter<Usuario, UsuarioDto>()).toEntity(request);
        r.setClave(new String(DigestUtils.md5Digest(request.getClave().getBytes())));
        r.setFkPersona(p);
        r.setFkRole(rr);

        usuarios.save(r);
        return bc.toDTO(r);
    }

}
