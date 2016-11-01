/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.personas.handlers;

import gt.org.isis.api.AbstractRequestHandler;
import gt.org.isis.controller.dto.EstudioSaludDto;
import gt.org.isis.controller.dto.IdiomaDto;
import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.converters.DpiDtoConverter;
import gt.org.isis.converters.EstudiosSaludConverter;
import gt.org.isis.converters.IdiomaDtoConverter;
import gt.org.isis.converters.LugarResidenciaDtoConverter;
import gt.org.isis.converters.PersonaDtoConverter;
import gt.org.isis.converters.PersonaHistorialConverter;
import gt.org.isis.converters.RegistroAcademicoConverter;
import gt.org.isis.converters.RegistroLaboralConverter;
import gt.org.isis.model.Dpi;
import gt.org.isis.model.EstudioSalud;
import gt.org.isis.model.HistoricoPersona;
import gt.org.isis.model.Idioma;
import gt.org.isis.model.LugarResidencia;
import gt.org.isis.model.Persona;
import gt.org.isis.model.RegistroAcademico;
import gt.org.isis.model.RegistroLaboral;
import gt.org.isis.model.enums.EstadoVariable;
import gt.org.isis.model.utils.EntitiesHelper;
import gt.org.isis.repository.EstudiosSaludRepository;
import gt.org.isis.repository.HIstoricoPersonasRepository;
import gt.org.isis.repository.IdiomaRepository;
import gt.org.isis.repository.PersonasRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edcracken
 */
@Service
public class PersonaModificarHandler extends AbstractRequestHandler<PersonaDto, Boolean> {

    @Autowired
    PersonasRepository repo;
    @Autowired
    HIstoricoPersonasRepository historicoRepo;
    @Autowired
    IdiomaRepository idiomasRepo;
    @Autowired
    EstudiosSaludRepository estudiosRepo;
    @Autowired
    PersonaDtoConverter converter;

    @Override
    public Boolean execute(PersonaDto r) {
        Persona p = repo.findOne(r.getCui());
        crearHistorico(p);
        guardaIdiomas(p, r);
        guardaEstudiosSalud(p, r);
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

        Dpi dpi;
        p.setDpiCollection(Arrays.asList(dpi = new DpiDtoConverter().toEntity(r.getDpi())));
        p.setEstudioSaludCollection(
                new EstudiosSaludConverter()
                        .toEntity(r.getEstudiosSalud()));
        dpi.setFkPersona(p);
        dpi.setEstado(EstadoVariable.ACTUAL);
        EntitiesHelper.setDateCreateRef(dpi);

        LugarResidencia lr;
        p.setLugarResidenciaCollection(Arrays.asList(
                lr = new LugarResidenciaDtoConverter().toEntity(r.getLugarResidencia())
        ));
        lr.setFkPersona(p);
        lr.setEstado(EstadoVariable.ACTUAL);
        EntitiesHelper.setDateCreateRef(dpi);

        EntitiesHelper.setDateCreateRef(p);
        repo.save(p);
        return true;
    }

    private void guardaEstudiosSalud(Persona p, PersonaDto r) {
        estudiosRepo.deleteInBatch(p.getEstudioSaludCollection());

        for (EstudioSaludDto t : r.getEstudiosSalud()) {
            EstudioSalud i = new EstudiosSaludConverter().toEntity(t);
            EntitiesHelper.setDateCreateRef(i);
            estudiosRepo.save(i);
        }
    }

    private void guardaIdiomas(Persona p, PersonaDto r) {
        idiomasRepo.deleteInBatch(p.getIdiomaCollection());
        for (IdiomaDto t : r.getIdiomas()) {
            Idioma i = new IdiomaDtoConverter().toEntity(t);
            EntitiesHelper.setDateCreateRef(i);
            idiomasRepo.save(i);
        }
    }

    private void crearHistorico(Persona p) {
        HistoricoPersona hp = new PersonaHistorialConverter().toEntity(p);
        hp.setFkPersona(p);
        EntitiesHelper.setDateCreateRef(hp);
        historicoRepo.save(hp);
    }

}
