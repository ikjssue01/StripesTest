/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.usuarios.handlers;

import gt.org.isis.api.AbstractRequestHandler;
import static gt.org.isis.api.ValidationsHelper.isNull;
import gt.org.isis.api.misc.exceptions.ExceptionsManager;
import gt.org.isis.controller.dto.UsuarioDto;
import gt.org.isis.converters.UsuarioDtoConverter;
import gt.org.isis.model.Role;
import gt.org.isis.model.Usuario;
import gt.org.isis.model.utils.EntitiesHelper;
import gt.org.isis.repository.PersonasRepository;
import gt.org.isis.repository.RolesRepository;
import gt.org.isis.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 *
 * @author edcracken
 */
@Service
public class CrearUsHandler extends AbstractRequestHandler<UsuarioDto, UsuarioDto> {

    @Autowired
    RolesRepository roles;
    @Autowired
    UsuariosRepository usuarios;
    @Autowired
    PersonasRepository personas;

    @Override
    public UsuarioDto execute(final UsuarioDto request) {

        Role role = roles.findOne(request.getRoleId());
        if (isNull(role)) {
            throw ExceptionsManager.newValidationException("invalid_role",
                    new String[]{"role_id,Role es invalido o no existe"});
        }
        UsuarioDtoConverter bc;
        final Usuario r = (bc = new UsuarioDtoConverter()).toEntity(request);
        r.setClave(new String(DigestUtils.md5Digest(request.getClave().getBytes())));

        r.setFkRole(role);
        r.setId(request.getUsuario());
        EntitiesHelper.setDateCreateRef(r);
        r.setCreadoPor("test");

        UsuarioDto us = bc.toDTO(usuarios.save(r));
        us.setClave(null);
        us.setConfirmacionClave(null);

        //        Persona persona = personas.findOne(request.getCui());
//        r.setFkPersona(persona);
        return us;
    }

}
