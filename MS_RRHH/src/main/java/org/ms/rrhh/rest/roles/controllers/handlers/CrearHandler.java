/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.roles.controllers.handlers;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import org.ms.rrhh.api.AbstractRequestHandler;
import org.ms.rrhh.dao.AccesoDao;
import org.ms.rrhh.dao.AccesoRoleDao;
import org.ms.rrhh.dao.RolesDao;
import org.ms.rrhh.domain.model.AccesoRole;
import org.ms.rrhh.domain.model.Role;
import org.ms.rrhh.domain.utils.BeansConverter;
import org.ms.rrhh.domain.utils.EntitiesHelper;
import org.ms.rrhh.rest.dto.AccesoDto;
import org.ms.rrhh.rest.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author eliud
 */
@Component
public class CrearHandler extends AbstractRequestHandler<RoleDto, Role> {

    @Autowired
    RolesDao roles;
    @Autowired
    AccesoDao accesos;
    @Autowired
    AccesoRoleDao accesosRole;

    @Override
    public Role execute(final RoleDto request) {
        final Role r = new BeansConverter<Role, RoleDto>().toEntity(request);
        r.setAccesoRoleCollection(Collections2.transform(request.getAccesos(), new Function<AccesoDto, AccesoRole>() {
            @Override
            public AccesoRole apply(AccesoDto f) {
                AccesoRole acceso = new AccesoRole();
                acceso.setFkAcceso(accesos.getOne(f.getId()));
                acceso.setFkRole(r);
                acceso.setCreadoPor(request.getUsuario());
                EntitiesHelper.setDateCreateRef(acceso);
                return acceso;
            }
        }));
        roles.save(r);
        return r;
    }

}
