/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.rest.roles.controllers.handlers;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import org.ms.rrhh.api.AbstractRequestHandler;
import org.ms.rrhh.api.dao.impl.CrudRepository;
import org.ms.rrhh.domain.model.Acceso;
import org.ms.rrhh.domain.model.AccesoRole;
import org.ms.rrhh.domain.model.Role;
import org.ms.rrhh.domain.utils.EntitiesHelper;
import org.ms.rrhh.rest.dto.AccesoDto;
import org.ms.rrhh.rest.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author edcracken
 */
@Component
public class ModificarHandler extends AbstractRequestHandler<RoleDto, RoleDto> {

    @Autowired("rolesDao")
    CrudRepository<Role> roles;
    @Autowired("accesosDao")
    CrudRepository<Acceso> accesos;
    @Autowired("accesosRoleDao")
    CrudRepository<AccesoRole> accesosRole;

    @Override
    public RoleDto execute(final RoleDto request) {
        final Role r = roles.getOne(request.getId());
        r.setNombre(request.getNombre());
        for (AccesoRole ar : r.getAccesoRoleCollection()) {
            accesosRole.delete(ar);
        }
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
        roles.update(r);
        return request;
    }

}
