/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.usuarios.controllers.handlers;

import org.ms.rrhh.api.AbstractRequestHandler;
import org.ms.rrhh.dao.PersonasDao;
import org.ms.rrhh.dao.RolesDao;
import org.ms.rrhh.dao.UsuariosDao;
import org.ms.rrhh.domain.model.Persona;
import org.ms.rrhh.domain.model.Role;
import org.ms.rrhh.domain.model.Usuario;
import org.ms.rrhh.domain.utils.BeansConverter;
import org.ms.rrhh.rest.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 *
 * @author edcracken
 */
@Component
public class ModificarUsHandler extends AbstractRequestHandler<UsuarioDto, UsuarioDto> {

    @Autowired
    RolesDao roles;
    @Autowired
    UsuariosDao usuarios;
    @Autowired
    PersonasDao personas;

    @Override
    public UsuarioDto execute(final UsuarioDto request) {
        Usuario r = usuarios.getOne(request.getUsuario());
        Persona p = personas.getOne(request.getCui());
        Role rr = roles.getOne(request.getRoleId());
        BeansConverter<Usuario, UsuarioDto> bc = new BeansConverter<Usuario, UsuarioDto>();
        r.setClave(new String(DigestUtils.md5Digest(request.getClave().getBytes())));
        r.setFkPersona(p);
        r.setFkRole(rr);

        usuarios.save(r);
        return bc.toDTO(r);
    }

}
