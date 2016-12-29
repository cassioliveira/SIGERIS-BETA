package br.com.cassioliveira.agendador.controllers;

import br.com.cassioliveira.agendador.enumerations.SchedulingStatus;
import br.com.cassioliveira.agendador.enumerations.SchedulingTypes;
import br.com.cassioliveira.agendador.enumerations.TravelReasons;
import br.com.cassioliveira.agendador.model.Scheduling;
import br.com.cassioliveira.agendador.services.SchedulingService;
import br.com.cassioliveira.agendador.services.TravelService;
import br.com.cassioliveira.agendador.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
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
        stockMovement();
        this.scheduling.setStatus(SchedulingStatus.OPEN);
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

//    public List<Scheduling> getSchedulings() {
//        if(scheduling.getDateTime().after(DateTimeUtilBean.getDateToday())){
//            scheduling.setStatus(SchedulingStatus.CLOSE);
//        }
//        return this.schedulings;
//    }
    /**
     * Retorna todos os agendamentos nos quais o status está como livre.
     * ******** ACREDITO QUE AQUI DÁ PRA FAZER UM STRATEGY POIS O METODO PRA
     * RETORNAR OS AGENDAMENTOS ABERTOS E FECHADOS É PRATICAMENTE O MESMO, SÓ
     * ALTERANDO O STATUS PARA RETORNO.
     *
     * @return
     */
    public List<Scheduling> getOpenedSchedulings() {
        List<Scheduling> openedSchedulings = new ArrayList<>();

        for (Scheduling openedSchedule : schedulings) {
            if (openedSchedule.getStatus() == SchedulingStatus.OPEN) {
                openedSchedulings.add(openedSchedule);
            }
        }

        return openedSchedulings;
    }

    /**
     * Fecha um agendamento aberto, definindo a data do fechamento com a hora
     * atual. ********AQUI TEM QUE FAZER UM STRATEGY ENTRE O FECHAMENTO DE
     * AGENDAMENTO DE SALA E EQUIPAMENTO JÁ QUE O EQUIPAMENTO TEM QUE RETORNAR
     * AO ESTOQUE*********
     */
    public void closeSchedule() {
        scheduling.setStatus(SchedulingStatus.CLOSE);
        scheduling.setEndingSchedulingDateTime(new Date());
        stockMovement();
        schedulingService.save(scheduling);
        FacesUtil.sucessAndRedirect("Baixa de agendamento realizada com sucesso!", "/SIGERIS/home.xhtml");
    }

    public void stockMovement() {
        schedulingService.stockMovement(scheduling, "/Agendador/agendamento/cadastro-agendamento.xhtml", "/Agendador/agendamento/baixa-equipamento.xhtml");
    }
}
