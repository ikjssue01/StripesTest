/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.personas;

import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.web.annotation.CrossOrigin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eliud
 */
@Controller
@RequestMapping("personas")
public class Crear {

    @CrossOrigin
    @RequestMapping(value = "/crea", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public void crear(@RequestBody PersonaDto persona) {

    }
}
