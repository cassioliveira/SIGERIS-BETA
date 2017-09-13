package br.com.cassioliveira.sigeris.converters;

import br.com.cassioliveira.sigeris.exceptions.SchedulerException;
import br.com.cassioliveira.sigeris.model.Discipline;
import br.com.cassioliveira.sigeris.services.DisciplineService;
import br.com.cassioliveira.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Discipline.class)
public class DisciplineConverter implements Converter {

    private final DisciplineService disciplineService;

    public DisciplineConverter() throws SchedulerException {
        this.disciplineService = CDIServiceLocator.getBean(DisciplineService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Discipline objectToReturn = null;

        if (value != null) {
            objectToReturn = this.disciplineService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Discipline) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
