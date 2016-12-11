package br.com.cassioliveira.agendador.converters;

import br.com.cassioliveira.agendador.exceptions.SchedulerException;
import br.com.cassioliveira.agendador.model.Subject;
import br.com.cassioliveira.agendador.services.SubjectService;
import br.com.cassioliveira.agendador.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Subject.class)
public class SubjectConverter implements Converter {

    private final SubjectService subjectService;

    public SubjectConverter() throws SchedulerException {
        this.subjectService = CDIServiceLocator.getBean(SubjectService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Subject objectToReturn = null;

        if (value != null) {
            objectToReturn = this.subjectService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Subject) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
