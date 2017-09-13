package br.com.cassioliveira.sigeris.converters;

import br.com.cassioliveira.sigeris.exceptions.SchedulerException;
import br.com.cassioliveira.sigeris.model.Teacher;
import br.com.cassioliveira.sigeris.services.TeacherService;
import br.com.cassioliveira.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Teacher.class)
public class TeacherConverter implements Converter {

    private final TeacherService teacherService;

    public TeacherConverter() throws SchedulerException {
        this.teacherService = CDIServiceLocator.getBean(TeacherService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Teacher objectToReturn = null;

        if (value != null) {
            objectToReturn = this.teacherService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Teacher) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
