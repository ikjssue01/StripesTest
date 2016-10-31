/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.catalogos.puestos.handlers;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import gt.org.isis.api.AbstractRequestHandler;
import gt.org.isis.controller.dto.CatalogoDto;
import gt.org.isis.controller.dto.CatalogosRequestDto;
import gt.org.isis.controller.dto.PuestoDto;
import gt.org.isis.converters.CatalogosDtoConverter;
import gt.org.isis.model.Catalogos;
import gt.org.isis.repository.PuestosRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edcracken
 */
@Service
public class PuestosBuscarTodosHandler extends AbstractRequestHandler<CatalogosRequestDto, List<PuestoDto>> {

    @Autowired
    PuestosRepository catalogos;
    @Autowired
    PuestosSpec spec;

    @Override
    public List<PuestoDto> execute(CatalogosRequestDto request) {
        return new ArrayList<PuestoDto>(Collections2
                .transform(catalogos.findAll(spec.build(request)),
                        new Function<Catalogos, CatalogoDto>() {
                    @Override
                    public CatalogoDto apply(Catalogos r) {
                        return new CatalogosDtoConverter().toDTO(r);
                    }
                }));
    }

}
