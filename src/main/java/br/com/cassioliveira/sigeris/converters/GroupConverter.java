package br.com.cassioliveira.sigeris.converters;

import br.com.cassioliveira.sigeris.exceptions.SchedulerException;
import br.com.cassioliveira.sigeris.model.Grupo;
import br.com.cassioliveira.sigeris.services.GroupService;
import br.com.cassioliveira.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Grupo.class)
public class GroupConverter implements Converter {

    private final GroupService groupService;

    public GroupConverter() throws SchedulerException {
        this.groupService = CDIServiceLocator.getBean(GroupService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Grupo objectToReturn = null;

        if (value != null) {
            objectToReturn = this.groupService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Grupo) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
