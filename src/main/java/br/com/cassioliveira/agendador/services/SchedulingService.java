package br.com.cassioliveira.agendador.services;

import br.com.cassioliveira.agendador.model.Room;
import br.com.cassioliveira.agendador.model.Scheduling;
import br.com.cassioliveira.agendador.repository.Schedulings;
import br.com.cassioliveira.agendador.util.jpa.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
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

    /**
     * Gera um código para identificar o agendamento.
     *
     * @param scheduling
     * @param room
     * @return
     */
    public String schedulingCode(Scheduling scheduling) {
        LocalDate dateToday = null;
        String code = null;
        if (scheduling.getType().equals("Sala")) {
            code = "AS" + dateToday.getMonthValue() + "0" + scheduling.getRoom().getId();
        } else if (scheduling.getType().equals("Equipamento")) {
            code = "AE" + dateToday.getMonthValue() + "0" + scheduling.getEquipment().getId();
        }

        return code;
    }

    /**
     * Verifica a se a tela de atual é a de cadastro ou baixa do agendamento e
     * retira uma unidade da quantidade do estoque do item agendado ou adiciona
     * uma unidade na quantidade do estoque do item agendado, respectivamente.
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
