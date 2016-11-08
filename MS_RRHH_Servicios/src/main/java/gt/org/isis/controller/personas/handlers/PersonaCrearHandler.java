/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.personas.handlers;

import gt.org.isis.api.AbstractValidationsRequestHandler;
import gt.org.isis.controller.dto.ReqNuevaPersonaDto;
import gt.org.isis.converters.DpiDtoConverter;
import gt.org.isis.converters.EstudiosSaludConverter;
import gt.org.isis.converters.IdiomaDtoConverter;
import gt.org.isis.converters.LugarResidenciaDtoConverter;
import gt.org.isis.converters.PersonaDtoConverter;
import gt.org.isis.converters.RegistroAcademicoConverter;
import gt.org.isis.converters.RegistroLaboralConverter;
import gt.org.isis.model.Dpi;
import gt.org.isis.model.LugarResidencia;
import gt.org.isis.model.Persona;
import gt.org.isis.model.RegistroAcademico;
import gt.org.isis.model.RegistroLaboral;
import gt.org.isis.model.enums.Estado;
import gt.org.isis.model.enums.EstadoVariable;
import gt.org.isis.model.utils.EntitiesHelper;
import gt.org.isis.repository.PersonasRepository;
import java.util.Arrays;
import java.util.Calendar;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edcracken
 */
@Service
public class PersonaCrearHandler extends AbstractValidationsRequestHandler<ReqNuevaPersonaDto, Boolean> {

    @Autowired
    PersonasRepository repo;
    @Autowired
    PersonaDtoConverter converter;

    @Override
    public Boolean execute(ReqNuevaPersonaDto r) {
        Persona p = converter.toEntity(r);
        p.setEstado(Estado.ACTIVO);
        p.setCui(r.getCui());
        p.setCreadoPor("admin");
        p.setEdad(Years.yearsBetween(LocalDate.fromDateFields(p.getFechaNacimiento()),
                LocalDate.fromDateFields(Calendar.getInstance().getTime())).getYears());
        EntitiesHelper.setDateCreateRef(p);
        repo.save(p);
        p.setIdiomaCollection(new IdiomaDtoConverter().toEntity(r.getIdiomas()));

        RegistroAcademico ra;
        p.setRegistroAcademicoCollection(
                Arrays.asList(
                        ra = new RegistroAcademicoConverter().toEntity(r.getRegistroAcademico())));
        ra.setFkPersona(p);
        ra.setEstado(EstadoVariable.ACTUAL);
        EntitiesHelper.setDateCreateRef(ra);

        RegistroLaboral rl;
        p.setRegistroLaboralCollection(
                Arrays.asList(rl = new RegistroLaboralConverter().toEntity(r.getRegistroLaboral()))
        );
        rl.setEstado(EstadoVariable.ACTUAL);
        rl.setFkPersona(p);
        EntitiesHelper.setDateCreateRef(rl);

        p.setEstudioSaludCollection(
                new EstudiosSaludConverter()
                        .toEntity(r.getEstudiosSalud()));

        Dpi dpi;
        p.setDpiCollection(Arrays.asList(dpi = new DpiDtoConverter().toEntity(r.getDpi())));
        dpi.setFkPersona(p);
        dpi.setEstado(EstadoVariable.ACTUAL);
        EntitiesHelper.setDateCreateRef(dpi);

        LugarResidencia lr;
        p.setLugarResidenciaCollection(Arrays.asList(
                lr = new LugarResidenciaDtoConverter().toEntity(r.getLugarResidencia())
        ));
        lr.setFkPersona(p);
        lr.setEstado(EstadoVariable.ACTUAL);
        EntitiesHelper.setDateCreateRef(lr);

        repo.save(p);
        return true;
    }

}
