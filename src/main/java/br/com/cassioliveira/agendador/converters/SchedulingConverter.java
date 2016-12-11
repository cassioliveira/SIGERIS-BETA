package br.com.cassioliveira.agendador.converters;

import br.com.cassioliveira.agendador.exceptions.SchedulerException;
import br.com.cassioliveira.agendador.model.Scheduling;
import br.com.cassioliveira.agendador.services.SchedulingService;
import br.com.cassioliveira.agendador.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Scheduling.class)
public class SchedulingConverter implements Converter {

    private final SchedulingService schedulingService;

    public SchedulingConverter() throws SchedulerException {
        this.schedulingService = CDIServiceLocator.getBean(SchedulingService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Scheduling objectToReturn = null;

        if (value != null) {
            objectToReturn = this.schedulingService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Scheduling) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
