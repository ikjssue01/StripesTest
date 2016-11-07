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
import gt.org.isis.model.Puesto_;
import gt.org.isis.model.Puestos;
import gt.org.isis.model.enums.CampoBusquedaAvanzada;
import gt.org.isis.model.enums.TipoPuestosCatalogo;
import gt.org.isis.model.utils.EntitiesHelper;
import gt.org.isis.repository.LugarResidenciaRepository;
import gt.org.isis.repository.PersonasRepository;
import gt.org.isis.repository.PuestoRepository;
import gt.org.isis.repository.PuestosRepository;
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
    PuestoRepository puestoRepo;

    @Autowired
    PuestosRepository puestosRepo;

    @Autowired
    LugarResidenciaRepository lugarRepo;

    @Override
    public PageableResultDto<PersonaDto> execute(final BusquedaAvanzadaDto request) {
        List<Persona> personas = new ArrayList();
        for (final FiltroAvanzadoDto f : request.getFiltros()) {
            if (f.getCampo().equals(CampoBusquedaAvanzada.CLASIFICACION_SERVICIO)) {
                personas.addAll(EntitiesHelper.getPersonas(puestoRepo.findAll(new PuestoPorFiltroAvanzadoQSpec(f,
                        Puesto_.fkClasificacionServicio))));
            }
            if (f.getCampo().equals(CampoBusquedaAvanzada.PUESTO_FUNCIONAL)) {
                personas.addAll(EntitiesHelper.getPersonas(puestoRepo.findAll(new PuestoPorFiltroAvanzadoQSpec(f,
                        Puesto_.fkPuestoFuncional))));
            }
            if (f.getCampo().equals(CampoBusquedaAvanzada.PUESTO_NOMINAL)) {
                personas.addAll(EntitiesHelper.getPersonas(puestoRepo.findAll(new PuestoPorFiltroAvanzadoQSpec(f,
                        Puesto_.fkPuestoNominal))));
            }
            if (f.getCampo().equals(CampoBusquedaAvanzada.ANIO_INGRESO)) {
                personas.addAll(EntitiesHelper
                        .getPersonas(rLaboralRepo
                                .findAll(new RegistroLaboralQSpec(f))));
            }
            if (f.getCampo().equals(CampoBusquedaAvanzada.REGLON)) {
                personas.addAll(EntitiesHelper.getPersonas(puestosRepo
                        .findAll(new PuestoQSpec(
                                (List<Integer>) Collections2
                                        .transform(puestosRepo.findAll(
                                                new PuestosPorPadreQSpec(Integer.valueOf(f.getValor1()),
                                                        TipoPuestosCatalogo.PUESTO_NOMINAL)),
                                                new Function<Puestos, Integer>() {
                                            @Override
                                            public Integer apply(Puestos f) {
                                                return f.getId();
                                            }
                                        })))));
            }

        }
        return null;
    }

}
