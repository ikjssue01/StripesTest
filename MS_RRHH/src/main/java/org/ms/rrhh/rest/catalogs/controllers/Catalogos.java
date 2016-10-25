/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.catalogs.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author eliud
 */
@Controller("catalogos")
public class Catalogos {

    @RequestMapping(value = "/{tipo}", headers = "Content-Type=application/json")
    public @ResponseBody
    List getCatalogo(@PathVariable("tipo") Integer tipo,
            @RequestParam(value = "padre", required = false) Integer idPadre) {
        return null;
    }

}
