package br.com.cassioliveira.agendador.converters;

import br.com.cassioliveira.agendador.exceptions.SchedulerException;
import br.com.cassioliveira.agendador.model.Equipment;
import br.com.cassioliveira.agendador.services.EquipmentService;
import br.com.cassioliveira.agendador.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Equipment.class)
public class EquimentConverter implements Converter {

    private final EquipmentService equipmentService;

    public EquimentConverter() throws SchedulerException {
        this.equipmentService = CDIServiceLocator.getBean(EquipmentService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Equipment objectToReturn = null;

        if (value != null) {
            objectToReturn = this.equipmentService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Equipment) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
