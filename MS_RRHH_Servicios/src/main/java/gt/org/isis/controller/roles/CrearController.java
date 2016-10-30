/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.roles;

import gt.org.isis.controller.dto.RoleDto;
import gt.org.isis.controller.roles.handlers.CrearHandler;
import gt.org.isis.model.Role;
import gt.org.isis.model.utils.BeansConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eliud
 */
@Controller("crearAccesos")
@RequestMapping("roles")
public class CrearController {

    @Autowired
    CrearHandler crear;

    @RequestMapping(value = "/crea", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public RoleDto crear(@RequestBody RoleDto persona) {
        return new BeansConverter<Role, RoleDto>().toDTO(crear.handle(persona));
    }
}
