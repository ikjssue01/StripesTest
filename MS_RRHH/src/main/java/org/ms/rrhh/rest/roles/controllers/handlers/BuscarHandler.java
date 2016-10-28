/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.roles.controllers.handlers;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import java.util.List;
import org.ms.rrhh.api.AbstractRequestHandler;
import org.ms.rrhh.api.dao.impl.CrudRepository;
import org.ms.rrhh.domain.model.Acceso;
import org.ms.rrhh.domain.model.AccesoRole;
import org.ms.rrhh.domain.model.Role;
import org.ms.rrhh.domain.utils.BeansConverter;
import org.ms.rrhh.rest.dto.AccesoDto;
import org.ms.rrhh.rest.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author edcracken
 */
@Component
public class BuscarHandler extends AbstractRequestHandler<RoleDto, RoleDto> {

    @Autowired("rolesDao")
    CrudRepository<Role> roles;
    @Autowired("accesosDao")
    CrudRepository<Acceso> accesos;

    @Override
    public RoleDto execute(final RoleDto request) {
        Role r;
        RoleDto rd = new BeansConverter<Role, RoleDto>().toDTO(r = roles.getOne(request.getId()));
        rd.setAccesos((List) Collections2.transform(r.getAccesoRoleCollection(),
                new Function<AccesoRole, AccesoDto>() {
            @Override
            public AccesoDto apply(AccesoRole f) {
                return new BeansConverter<Acceso, AccesoDto>().toDTO(f.getFkAcceso());
            }
        }));
        return rd;
    }

}
