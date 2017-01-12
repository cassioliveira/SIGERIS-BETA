package br.com.cassioliveira.agendador.controllers;

import br.com.cassioliveira.agendador.enumerations.StatusType;
import br.com.cassioliveira.agendador.enumerations.SchedulingTypes;
import br.com.cassioliveira.agendador.enumerations.TravelReasons;
import br.com.cassioliveira.agendador.model.Scheduling;
import br.com.cassioliveira.agendador.services.SchedulingService;
import br.com.cassioliveira.agendador.services.TravelService;
import br.com.cassioliveira.agendador.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
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

    @Getter
    private List<Scheduling> schedulings;

    @Getter
    List<SchedulingTypes> schedulingTypes;

    @Getter
    DateTimeUtilBean dateTime;

    @Getter
    List<TravelReasons> travelReasons;

    @PostConstruct
    public void init() {
        this.schedulings = schedulingService.findAll();
        this.schedulingTypes = Arrays.asList(SchedulingTypes.values());
    }

    public void save() {
        if (scheduling.getType().equals("Equipamento")) {
            stockMovement();
        } else {
            this.scheduling.getRoom().setStatus(StatusType.BUSY);
        }
        this.scheduling.setStatus(StatusType.OPEN);
        this.schedulingService.save(scheduling);
        if (getEditing()) {
            FacesUtil.sucessMessage("Agendamento de " + scheduling.getType() + " atualizado com sucesso!");
        } else {
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

    /**
     * Verifica se o objeto esta nulo quando for recuperado. Se sim, refere-se a
     * um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditing() {
        return scheduling.getId() != null;
    }

    public List<Scheduling> getOpenedSchedulings() {
        return schedulingService.openedSchedulings();
    }

    public List<Scheduling> getClosedSchedulings() {
        return schedulingService.closedSchedulings();
    }

    /**
     * Verifica se há agendamentos onde a data de previsão de finalização do
     * mesmo é anterior à data e hora atual. Caso seja, o agendamento é
     * finalizado e a sala é liberada.
     */
    public void checkDateScheduledRoomNow() {
        Date now = new Date();
        for (Scheduling openedScheduling : getOpenedSchedulings()) {
            scheduling = openedScheduling;
            if (scheduling.getId() != null
                    && scheduling.getType().equals("Sala")
                    && now.after(scheduling.getForecastSchedulingDateTime())) {

                scheduling.setStatus(StatusType.CLOSE);
                scheduling.setEndingSchedulingDateTime(new Date());
                scheduling.getRoom().setStatus(StatusType.FREE);
                schedulingService.save(scheduling);
            }
        }
    }

    /**
     * Fecha um agendamento aberto, definindo a data do fechamento com a hora
     * atual. ********AQUI TEM QUE FAZER UM STRATEGY ENTRE O FECHAMENTO DE
     * AGENDAMENTO DE SALA E EQUIPAMENTO JÁ QUE O EQUIPAMENTO TEM QUE RETORNAR
     * AO ESTOQUE*********
     */
    public void closeSchedule() {
        scheduling.setStatus(StatusType.CLOSE);
        scheduling.setEndingSchedulingDateTime(new Date());
        if (scheduling.getType().equals("Equipamento")) {
            stockMovement();
        } else {
            this.scheduling.getRoom().setStatus(StatusType.FREE);
        }
        schedulingService.save(scheduling);
        FacesUtil.sucessAndRedirect("Baixa de agendamento realizada com sucesso!", "/SIGERIS/home.xhtml");
    }

    public void stockMovement() {
        schedulingService.stockMovement(scheduling, "/Agendador/agendamento/cadastro-agendamento.xhtml", "/Agendador/agendamento/baixa-equipamento.xhtml");
    }
}
