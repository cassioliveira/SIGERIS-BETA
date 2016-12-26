//package br.com.cassioliveira.agendador.converters;
//
//import br.com.cassioliveira.agendador.exceptions.SchedulerException;
//import br.com.cassioliveira.agendador.model.EquipmentType;
//import br.com.cassioliveira.agendador.services.EquipmentTypeService;
//import br.com.cassioliveira.agendador.util.cdi.CDIServiceLocator;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.FacesConverter;
//
///**
// *
// * @author cassio
// */
//@FacesConverter(forClass = EquipmentType.class)
//public class EquipmentTypeConverter implements Converter {
//
//    private final EquipmentTypeService equipmentTypeService;
//
//    public EquipmentTypeConverter() throws SchedulerException {
//        this.equipmentTypeService = CDIServiceLocator.getBean(EquipmentTypeService.class);
//    }
//
//    @Override
//    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//
//        EquipmentType objectToReturn = null;
//
//        if (value != null) {
//            objectToReturn = this.equipmentTypeService.findById(new Long(value));
//        }
//        return objectToReturn;
//    }
//
//    @Override
//    public String getAsString(FacesContext context, UIComponent component, Object value) {
//
//        if (value != null) {
//            Long code = ((EquipmentType) value).getId();
//            return code == null ? null : code.toString();
//        }
//        return "";
//    }
//}
