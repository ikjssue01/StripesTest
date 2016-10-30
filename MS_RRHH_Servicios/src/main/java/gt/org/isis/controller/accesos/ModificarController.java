/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.accesos;

import gt.org.isis.controller.accesos.handlers.ModificarAcHandler;
import gt.org.isis.controller.dto.AccesoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eliud
 */
@Controller("modificarRole")
@RequestMapping("accesos")
public class ModificarController {

    @Autowired
    ModificarAcHandler handler;

    @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT, headers = "Content-Type=application/json")
    public void modificar(@PathVariable("id") Integer id, @RequestBody AccesoDto acceso) {
        handler.handle(acceso);
    }
}
