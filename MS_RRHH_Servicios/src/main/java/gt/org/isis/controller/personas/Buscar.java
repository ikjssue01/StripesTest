/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.personas;

import gt.org.isis.controller.dto.PersonaDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author edcracken
 */
@Controller
@RequestMapping("personas")
public class Buscar {

    @RequestMapping(value = "/get", method = RequestMethod.GET, headers = "Content-Type=application/json")
    public @ResponseBody
    PersonaDto getPersona(@RequestParam("cui") String cui) {
        return new PersonaDto("edcracken");
    }
}
