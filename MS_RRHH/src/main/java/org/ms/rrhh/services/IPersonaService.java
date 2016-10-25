/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.services;

import java.util.List;
import org.ms.rrhh.domain.model.Persona;

/**
 *
 * @author edcracken
 */
public interface IPersonaService {

    public List<Persona> getPersonas();

}
