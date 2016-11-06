/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.home.handlers;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import gt.org.isis.api.AbstractValidationsRequestHandler;
import gt.org.isis.controller.dto.BusquedaAvanzadaDto;
import gt.org.isis.controller.dto.FiltroAvanzadoDto;
import gt.org.isis.controller.dto.PageableResultDto;
import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.model.Persona;
import gt.org.isis.model.RegistroLaboral;
import gt.org.isis.model.enums.CampoBusquedaAvanzada;
import gt.org.isis.repository.LugarResidenciaRepository;
import gt.org.isis.repository.PersonasRepository;
import gt.org.isis.repository.RegistroLaboralRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author edcracken
 */
public class BusquedaAvanzadaHandler extends AbstractValidationsRequestHandler<BusquedaAvanzadaDto, PageableResultDto<PersonaDto>> {

    @Autowired
    PersonasRepository personasRepo;

    @Autowired
    RegistroLaboralRepository rLaboralRepo;

    @Autowired
    LugarResidenciaRepository lugarRepo;

    @Override
    public PageableResultDto<PersonaDto> execute(final BusquedaAvanzadaDto request) {
        List<Persona> personas = new ArrayList();
        for (final FiltroAvanzadoDto f : request.getFiltros()) {
            if (f.getCampo().equals(CampoBusquedaAvanzada.CLASIFICACION_SERVICIO)) {

            }
            if (f.getCampo().equals(CampoBusquedaAvanzada.ANIO_INGRESO)) {
                personas.addAll(Collections2.transform(rLaboralRepo.findAll(new RegistroLaboralQSpec(f)),
                        new Function<RegistroLaboral, Persona>() {
                    @Override
                    public Persona apply(RegistroLaboral f) {
                        return f.getFkPersona();
                    }
                }));
            }
        }
        return null;
    }

}
