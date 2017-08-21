package br.com.cassioliveira.sigeris.converters;

import br.com.cassioliveira.sigeris.exceptions.SchedulerException;
import br.com.cassioliveira.sigeris.model.Room;
import br.com.cassioliveira.sigeris.services.RoomService;
import br.com.cassioliveira.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Room.class)
public class RoomConverter implements Converter {

    private final RoomService roomService;

    public RoomConverter() throws SchedulerException {
        this.roomService = CDIServiceLocator.getBean(RoomService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Room objectToReturn = null;

        if (value != null) {
            objectToReturn = this.roomService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Room) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
