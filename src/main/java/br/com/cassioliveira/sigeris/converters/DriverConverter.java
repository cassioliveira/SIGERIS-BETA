package br.com.cassioliveira.sigeris.converters;

import br.com.cassioliveira.sigeris.exceptions.SchedulerException;
import br.com.cassioliveira.sigeris.model.Driver;
import br.com.cassioliveira.sigeris.services.DriverService;
import br.com.cassioliveira.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Driver.class)
public class DriverConverter implements Converter {

    private final DriverService driverService;

    public DriverConverter() throws SchedulerException {
        this.driverService = CDIServiceLocator.getBean(DriverService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Driver objectToReturn = null;

        if (value != null) {
            objectToReturn = this.driverService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Driver) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
