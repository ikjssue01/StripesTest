/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.usuarios.controllers.handlers;

import org.ms.rrhh.api.AbstractRequestHandler;
import org.ms.rrhh.dao.UsuariosDao;
import org.ms.rrhh.domain.model.Persona;
import org.ms.rrhh.domain.model.Usuario;
import org.ms.rrhh.domain.utils.BeansConverter;
import org.ms.rrhh.rest.dto.PersonaDto;
import org.ms.rrhh.rest.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author edcracken
 */
@Component
public class BuscarUsHandler extends AbstractRequestHandler<UsuarioDto, UsuarioDto> {

    @Autowired
    UsuariosDao accesos;

    @Override
    public UsuarioDto execute(final UsuarioDto request) {
        Usuario uOr = accesos.getOne(request.getUsuario());

        UsuarioDto u = new BeansConverter<Usuario, UsuarioDto>().toDTO(uOr);
        u.setClave("");
        u.setPersona(new BeansConverter<Persona, PersonaDto>().toDTO(uOr.getFkPersona()));
        return u;
    }

}
