/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.accesos.handlers;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import gt.org.isis.api.AbstractRequestHandler;
import gt.org.isis.controller.dto.AccesoDto;
import gt.org.isis.converters.AccesoDtoConverter;
import gt.org.isis.model.Acceso;
import gt.org.isis.repository.AccesoRoleRepository;
import gt.org.isis.repository.AccesosRepository;
import gt.org.isis.repository.RolesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edcracken
 */
@Service
public class BuscarAcTodosHandler extends AbstractRequestHandler<Object, List<AccesoDto>> {

    @Autowired
    RolesRepository roles;
    @Autowired
    AccesosRepository accesos;
    @Autowired
    AccesoRoleRepository accesosRole;

    @Override
    public List<AccesoDto> execute(final Object request) {
        return new ArrayList<AccesoDto>(Collections2.transform(accesos.findAll(), new Function<Acceso, AccesoDto>() {
            @Override
            public AccesoDto apply(Acceso r) {
                return new AccesoDtoConverter().toDTO(r);
            }
        }));
    }

}
