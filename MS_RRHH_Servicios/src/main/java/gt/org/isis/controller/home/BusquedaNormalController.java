/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.home;

import gt.org.isis.controller.dto.BusquedaNormalDto;
import javax.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author edcracken
 */
@Controller
@RequestMapping("home")
public class BusquedaNormalController {

    @Transactional
    @RequestMapping(value = "/busquedaNormal",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public HttpEntity buscar(@RequestBody @Valid BusquedaNormalDto acceso) {
        return new ResponseEntity(HttpStatus.IM_USED);
    }
}
