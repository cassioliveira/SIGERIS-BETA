package br.com.cassioliveira.sigeris.converters;

import br.com.cassioliveira.sigeris.exceptions.SchedulerException;
import br.com.cassioliveira.sigeris.model.Employee;
import br.com.cassioliveira.sigeris.services.EmployeeService;
import br.com.cassioliveira.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Employee.class)
public class EmployeeConverter implements Converter {

    private final EmployeeService employeeService;

    public EmployeeConverter() throws SchedulerException {
        this.employeeService = CDIServiceLocator.getBean(EmployeeService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Employee objectToReturn = null;

        if (value != null) {
            objectToReturn = this.employeeService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Employee) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
