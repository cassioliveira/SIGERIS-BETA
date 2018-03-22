package br.com.cassioliveira.sigeris.converters;

import br.com.cassioliveira.sigeris.exceptions.SchedulerException;
import br.com.cassioliveira.sigeris.model.Requester;
import br.com.cassioliveira.sigeris.services.RequesterService;
import br.com.cassioliveira.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Requester.class)
public class RequesterConverter implements Converter {

    private final RequesterService requesterService;

    public RequesterConverter() throws SchedulerException {
        this.requesterService = CDIServiceLocator.getBean(RequesterService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Requester objectToReturn = null;

        if (value != null) {
            objectToReturn = this.requesterService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Requester) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
