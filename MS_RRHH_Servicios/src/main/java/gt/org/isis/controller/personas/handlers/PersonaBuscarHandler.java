/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.controller.personas.handlers;

import gt.org.isis.api.AbstractRequestHandler;
import static gt.org.isis.api.ValidationsHelper.isNull;
import gt.org.isis.api.jpa.SingularAttrSpecificationBased;
import gt.org.isis.controller.dto.GetPersonaDto;
import gt.org.isis.controller.dto.PersonaDto;
import gt.org.isis.controller.dto.RegistroLaboralDto;
import gt.org.isis.converters.GetPersonaDtoConverter;
import gt.org.isis.converters.RegistroLaboralConverter;
import gt.org.isis.model.AreaGeografica;
import gt.org.isis.model.AreaGeografica_;
import gt.org.isis.model.Persona;
import gt.org.isis.model.RegistroLaboral;
import gt.org.isis.model.enums.EstadoVariable;
import gt.org.isis.repository.AreasGeografRepository;
import gt.org.isis.repository.CatalogosRepository;
import gt.org.isis.repository.PersonasRepository;
import gt.org.isis.repository.UnidadNotificadoraRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edcracken
 */
@Service
public class PersonaBuscarHandler extends AbstractRequestHandler<PersonaDto, PersonaDto> {

    @Autowired
    PersonasRepository repo;
    @Autowired
    AreasGeografRepository areasRepo;
    @Autowired
    UnidadNotificadoraRepository unidadEjeRepo;
    @Autowired
    CatalogosRepository catalogosRepo;
    @Autowired
    GetRegistroAcademicoHandler getRegAcademico;

    @Override
    public GetPersonaDto execute(PersonaDto request) {
        Persona p = repo.findOne(request.getCui());
        final GetPersonaDto dto = new GetPersonaDtoConverter().toDTO(p);
        //datos cedula
        AreaGeografica muni = (AreaGeografica) areasRepo
                .findOne(new SingularAttrSpecificationBased<AreaGeografica>(AreaGeografica_.id,
                        dto.getFkMunicipioCedula()));
        dto.setFkMunicioCedulaNombre(muni.getValor());
        AreaGeografica depto = (AreaGeografica) areasRepo.findOne(new SingularAttrSpecificationBased<AreaGeografica>(AreaGeografica_.id,
                muni.getCodigoPadre()));
        dto.setFkDepartamentoCedula(depto.getId());
        dto.setFkDepartamentoCedulaNombre(depto.getValor());

        AreaGeografica pais = (AreaGeografica) areasRepo.findOne(new SingularAttrSpecificationBased<AreaGeografica>(AreaGeografica_.id,
                depto.getCodigoPadre()));
        dto.setFkPaisCedula(pais.getId());

        //datos nacimiento
        muni = (AreaGeografica) areasRepo
                .findOne(new SingularAttrSpecificationBased<AreaGeografica>(AreaGeografica_.id,
                        dto.getFkMunicipioNacimiento()));
        dto.setFkMunicioNacNombre(muni.getValor());
        depto = (AreaGeografica) areasRepo.findOne(new SingularAttrSpecificationBased<AreaGeografica>(AreaGeografica_.id,
                muni.getCodigoPadre()));
        dto.setFkDepartamentoNac(depto.getId());
        dto.setFkDepartamentoNacNombre(depto.getValor());

        pais = (AreaGeografica) areasRepo.findOne(new SingularAttrSpecificationBased<AreaGeografica>(AreaGeografica_.id,
                depto.getCodigoPadre()));
        dto.setFkPaisNac(pais.getId());
        dto.setFkPaisNacNombre(pais.getValor());

        //datos vecindad
        muni = (AreaGeografica) areasRepo
                .findOne(new SingularAttrSpecificationBased<AreaGeografica>(AreaGeografica_.id,
                        dto.getFkMunicipioVecindad()));
        dto.setFkMunicioVecindadNombre(muni.getValor());
        depto = (AreaGeografica) areasRepo.findOne(new SingularAttrSpecificationBased<AreaGeografica>(AreaGeografica_.id,
                muni.getCodigoPadre()));
        dto.setFkDepartamentoVecindad(depto.getId());
        dto.setFkDepartamentoVecindadNombre(depto.getValor());

        pais = (AreaGeografica) areasRepo.findOne(new SingularAttrSpecificationBased<AreaGeografica>(AreaGeografica_.id,
                depto.getCodigoPadre()));
        dto.setFkPaisVecindad(pais.getId());
        dto.setFkPaisVecindadNombre(pais.getValor());

        //registro laboral
        RegistroLaboralDto currentRL = null;
        List<RegistroLaboralDto> histRL = new ArrayList<RegistroLaboralDto>();
        for (RegistroLaboral rl : p.getRegistroLaboralCollection()) {
            if (rl.getEstado().equals(EstadoVariable.ACTUAL)) {
                currentRL = new RegistroLaboralConverter().toDTO(rl);
                currentRL.setHistorial(histRL);
            } else {
                histRL.add(new RegistroLaboralConverter().toDTO(rl));
            }
        }

        if (isNull(currentRL)) {
            currentRL = !histRL.isEmpty() ? histRL.get(0) : null;
        }
        dto.setRegistroLaboral(currentRL);

        dto.setRegistroAcademico(getRegAcademico.handle((List) p.getRegistroAcademicoCollection()));

        return dto;
    }

}
