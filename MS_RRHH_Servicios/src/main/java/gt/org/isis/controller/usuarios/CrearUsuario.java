/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.usuarios;

import gt.org.isis.controller.dto.UsuarioDto;
import javax.validation.Valid;
import org.ms.rrhh.rest.usuarios.controllers.handlers.CrearUsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eliud
 */
@Controller("usuariosCrear")
@RequestMapping("usuarios")
public class CrearUsuario {

    @Autowired
    CrearUsHandler handler;

    @RequestMapping(value = "/crea", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public void crear(@RequestBody @Valid UsuarioDto usuario) {
        handler.handle(usuario);
    }
}
