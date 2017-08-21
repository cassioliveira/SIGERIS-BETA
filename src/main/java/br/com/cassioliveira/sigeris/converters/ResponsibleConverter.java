package br.com.cassioliveira.sigeris.converters;

import br.com.cassioliveira.sigeris.exceptions.SchedulerException;
import br.com.cassioliveira.sigeris.model.Responsible;
import br.com.cassioliveira.sigeris.services.ResponsibleService;
import br.com.cassioliveira.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Responsible.class)
public class ResponsibleConverter implements Converter {

    private final ResponsibleService responsibleService;

    public ResponsibleConverter() throws SchedulerException {
        this.responsibleService = CDIServiceLocator.getBean(ResponsibleService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Responsible objectToReturn = null;

        if (value != null) {
            objectToReturn = this.responsibleService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Responsible) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
