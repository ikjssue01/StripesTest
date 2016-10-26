/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.usuarios.controllers;

import org.ms.rrhh.rest.dto.PersonaDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author edcracken
 */
@Controller("usuariosBuscar")
@RequestMapping("usuarios")
public class BuscarUsuario {

    @RequestMapping("/get/{id}")
    public @ResponseBody
    PersonaDto getUsuario(@PathVariable("id") String cui) {
        return null;
    }
}
