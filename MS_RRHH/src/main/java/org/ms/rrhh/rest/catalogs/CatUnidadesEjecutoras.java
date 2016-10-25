/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.catalogs;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author eliud
 */
@Controller
public class CatUnidadesEjecutoras {

    @RequestMapping(value = "/unidades-ejecutoras")
    public List getUnidadesEjecutoras() {
        return null;
    }
}
