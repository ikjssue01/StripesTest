/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.model.utils;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import gt.org.isis.model.CustomEntity;
import gt.org.isis.model.Persona;
import gt.org.isis.model.PersonaChildEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 *
 * @author eliud
 */
public class EntitiesHelper {

    public static void setDateCreateRef(CustomEntity ce) {
        ce.setFechaCreacion(new DateTime().toDate());
    }

    public static void setDateUpdateRef(CustomEntity ce) {
        ce.setFechaUltimoCambio(new DateTime().toDate());
    }

    public static List<Persona> getPersonas(List<PersonaChildEntity> pc) {
        return new ArrayList<Persona>(Collections2.transform(pc,
                new Function<PersonaChildEntity, Persona>() {
            @Override
            public Persona apply(PersonaChildEntity f) {
                return f.getFkPersona();
            }
        }));
    }

    public static Integer getAge(Date birthDate) {
        return Years.yearsBetween(LocalDate.fromDateFields(birthDate),
                LocalDate.fromDateFields(Calendar.getInstance().getTime())).getYears();
    }

}
