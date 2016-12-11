package br.com.cassioliveira.agendador.controllers;

import br.com.cassioliveira.agendador.enumerations.SchedulingTypes;
import br.com.cassioliveira.agendador.enumerations.TravelReasons;
import br.com.cassioliveira.agendador.model.Scheduling;
import br.com.cassioliveira.agendador.services.SchedulingService;
import br.com.cassioliveira.agendador.services.TravelService;
import br.com.cassioliveira.agendador.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cássio Oliveira
 */
@Named
@ViewScoped
public class SchedulingBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private Scheduling scheduling;

    @Inject
    @Getter
    @Setter
    private SchedulingService schedulingService;

    @Inject
    @Getter
    @Setter
    private TravelService travelService;

    @Inject
    @Getter
    @Setter
    private Scheduling selectedScheduling;

    @Inject
    private DateTimeUtilBean dateTimeUtilBean;

    private List<Scheduling> schedulings;

    @Getter
    List<SchedulingTypes> schedulingTypes;

//    @Getter
//    List<String> originCities = new ArrayList<>();
//
//    @Getter
//    List<String> destinationCities = new ArrayList<>();
//
//    @Getter
//    List<States> originStates;
//
//    @Getter
//    List<States> destinationStates;
    @Getter
    List<TravelReasons> travelReasons;

    @PostConstruct
    public void init() {
        this.schedulings = schedulingService.findAll();
        this.schedulingTypes = Arrays.asList(SchedulingTypes.values());
//        this.originStates = Arrays.asList(States.values());
//        this.destinationStates = Arrays.asList(States.values());
//        this.travelReasons = Arrays.asList(TravelReasons.values());
    }

//    public void loadOriginCities() {
//        this.originCities.clear();
//        if (scheduling.getTravel().getOriginUf() != null) {
//            for (String filteredCities : travelService.returnCities(scheduling.getTravel().getOriginUf().getCode())) {
//                this.originCities.add(filteredCities);
//            }
//        }
//    }
//
//    public void loadDestinationCities() {
//        this.destinationCities.clear();
//        if (scheduling.getTravel().getUf() != null) {
//            for (String filteredCities : travelService.returnCities(scheduling.getTravel().getUf().getCode())) {
//                this.destinationCities.add(filteredCities);
//            }
//        }
//    }
    public void save() {
//        this.scheduling.setStatus(SchedulingStatus.OPEN);
//        scheduling.setRegisterDate(dateTimeUtilBean.getDateToday());
        this.schedulingService.save(scheduling);
        if (getEditing()) {
            FacesUtil.sucessMessage("Agendamentoj"
                    + " de " + scheduling.getType() + " atualizado com sucesso!");
        } else {
            scheduling.setRegisterDate(dateTimeUtilBean.getDateToday());
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirectTo("/SIGERIS/home.xhtml");
        scheduling = new Scheduling();
    }

    public void remove() {
        this.schedulingService.delete(selectedScheduling);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
        FacesUtil.redirectTo("/SIGERIS/home.xhtml");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.scheduling.getId() != null;
    }

    public List<Scheduling> getSchedulings() {
//        if(scheduling.getDateTime().after(DateTimeUtilBean.getDateToday())){
//            scheduling.setStatus(SchedulingStatus.CLOSE);
//        }
        return this.schedulings;
    }
}
