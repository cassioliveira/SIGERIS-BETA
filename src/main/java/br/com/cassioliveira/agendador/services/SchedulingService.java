package br.com.cassioliveira.agendador.services;

import br.com.cassioliveira.agendador.enumerations.Status;
import br.com.cassioliveira.agendador.exceptions.BusinessException;
import br.com.cassioliveira.agendador.model.Scheduling;
import br.com.cassioliveira.agendador.repository.Schedulings;
import br.com.cassioliveira.agendador.util.jpa.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela import org.apache.commons.logging.Log;
 */
public class SchedulingService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(SchedulingService.class);

    @Inject
    private Schedulings schedulings;

    @Transactional
    public void save(Scheduling scheduling) {
        this.schedulings.save(scheduling);
    }

    @Transactional
    public void delete(Scheduling scheduling) {
        schedulings.delete(findById(scheduling.getId()));
    }

    public Scheduling findById(Long id) {
        return schedulings.findById(id);
    }

    public List<Scheduling> findAll() {
        return schedulings.findAll();
    }

    public void isRoomScheduled(Scheduling scheduling) {
        List<Scheduling> all = findAll();
        if (all != null) {
            for (Scheduling selectedScheduling : all) {
                if (scheduling.getRoom().getId().equals(selectedScheduling.getId())
                        && scheduling.getStatus().equals(Status.BUSY)) {
                    throw new BusinessException("Sala já agendada para este horário");
                } else {
                    throw new BusinessException("Sala livre para agendamento");
                }
            }
        }
//        Long scheduledRoom = schedulings.scheduledRoom();
//        Long roomToSchedule = scheduling.getRoom().getId();
//        if (!Objects.equals(roomToSchedule, scheduledRoom)
//                && roomToSchedule != null
//                && scheduledRoom != null) {
//        }

//    && selectedScheduling.getForecastSchedulingDateTime().equals(new Date())
    }

    /**
     * Gera um código para identificar o agendamento.
     *
     * @param scheduling
     * @return
     */
    public String schedulingCode(Scheduling scheduling) {
        LocalDateTime dateToday = LocalDateTime.now();
        String code = "";
        if (scheduling.getType().equals("Sala")) {
            code = "AS" + scheduling.getResponsible().getId() + 
                    scheduling.getRoom().getId() + 
                    dateToday.format(DateTimeFormatter.ofPattern("MMss"));
        } else if (scheduling.getType().equals("Equipamento")) {
            code = "AE" + scheduling.getResponsible().getId() + 
                    scheduling.getEquipment().getId() + 
                    dateToday.format(DateTimeFormatter.ofPattern("MMss"));
        }
        System.out.println(code);
        return code;
    }

    /**
     * Retorna todos os agendamentos nos quais o status está como ABERTO. ******** ACREDITO QUE AQUI DÁ PRA
     * FAZER UM STRATEGY POIS O METODO PRA RETORNAR OS AGENDAMENTOS ABERTOS E FECHADOS É PRATICAMENTE O MESMO,
     * SÓ ALTERANDO O STATUS PARA RETORNO.
     *
     * @return
     */
    public List<Scheduling> openedSchedulings() {
        List<Scheduling> openedSchedulings = new ArrayList<>();
        for (Scheduling openedSchedule : findAll()) {
            if (openedSchedule.getStatus() == Status.OPEN) {
                openedSchedulings.add(openedSchedule);
            }
        }
        return openedSchedulings;
    }

    /**
     * Retorna todos os agendamentos nos quais o status está como FECHADO. ******** ACREDITO QUE AQUI DÁ PRA
     * FAZER UM STRATEGY POIS O METODO PRA RETORNAR OS AGENDAMENTOS ABERTOS E FECHADOS É PRATICAMENTE O MESMO,
     * SÓ ALTERANDO O STATUS PARA RETORNO.
     *
     * @return
     */
    public List<Scheduling> closedSchedulings() {
        List<Scheduling> closedSchedulings = new ArrayList<>();
        for (Scheduling closedSchedule : findAll()) {
            if (closedSchedule.getStatus() == Status.CLOSE) {
                closedSchedulings.add(closedSchedule);
            }
        }
        return closedSchedulings;
    }

    /**
     * Verifica a se a tela de atual é a de cadastro ou baixa do agendamento e retira uma unidade da
     * quantidade do estoque do item agendado ou adiciona uma unidade na quantidade do estoque do item
     * agendado, respectivamente.
     *
     * @param scheduling
     * @param registerPage
     * @param downPage
     */
    public void stockMovement(Scheduling scheduling, String registerPage, String downPage) {
        int quantityStock = scheduling.getEquipment().getQuantity();
        String path = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        if (path.equals(registerPage)) {
            scheduling.getEquipment().setQuantity(quantityStock - 1);
        } else if (path.equals(downPage)) {
            scheduling.getEquipment().setQuantity(quantityStock + 1);
        }
    }

}
