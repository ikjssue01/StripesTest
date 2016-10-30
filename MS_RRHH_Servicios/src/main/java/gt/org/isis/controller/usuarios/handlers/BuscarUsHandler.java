/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.usuarios.handlers;

import gt.org.isis.api.AbstractRequestHandler;
import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.controller.dto.UsuarioDto;
import gt.org.isis.model.Persona;
import gt.org.isis.model.Usuario;
import gt.org.isis.model.utils.BeansConverter;
import gt.org.isis.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edcracken
 */
@Service
public class BuscarUsHandler extends AbstractRequestHandler<UsuarioDto, UsuarioDto> {

    @Autowired
    UsuariosRepository accesos;

    @Override
    public UsuarioDto execute(final UsuarioDto request) {
        Usuario uOr = accesos.findOne(request.getUsuario());

        UsuarioDto u = new BeansConverter<Usuario, UsuarioDto>().toDTO(uOr);
        u.setClave("");
        u.setPersona(new BeansConverter<Persona, PersonaDto>().toDTO(uOr.getFkPersona()));
        return u;
    }

}
