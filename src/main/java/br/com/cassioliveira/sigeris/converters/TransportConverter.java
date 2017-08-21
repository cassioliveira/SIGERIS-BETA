package br.com.cassioliveira.sigeris.converters;

import br.com.cassioliveira.sigeris.exceptions.SchedulerException;
import br.com.cassioliveira.sigeris.model.Transport;
import br.com.cassioliveira.sigeris.services.TransportService;
import br.com.cassioliveira.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Transport.class)
public class TransportConverter implements Converter {

    private final TransportService transportService;

    public TransportConverter() throws SchedulerException {
        this.transportService = CDIServiceLocator.getBean(TransportService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Transport objectToReturn = null;

        if (value != null) {
            objectToReturn = this.transportService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Transport) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
