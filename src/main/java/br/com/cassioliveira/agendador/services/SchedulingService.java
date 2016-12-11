package br.com.cassioliveira.agendador.services;

import br.com.cassioliveira.agendador.model.Room;
import br.com.cassioliveira.agendador.model.Scheduling;
import br.com.cassioliveira.agendador.repository.Schedulings;
import br.com.cassioliveira.agendador.util.jpa.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
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
        if (scheduling != null) {
            this.schedulings.save(scheduling);
        }
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
     * Método responsável por gerar o codido do agendamento baseado nas regras definidas pelo desenvolvedor.
     * @param scheduling
     * @param room
     * @return 
     */
    public String schedulingCode(Scheduling scheduling, Room room){
        LocalDate dateToday = null;
        String code = null;
        if(scheduling.getType().equals("Sala")){
            code = "AS" + dateToday.getMonthValue() + "0" + room.getId();
        }else if(scheduling.getType().equals("Equipamento")){
            code = "AE" + dateToday.getMonthValue() + "0" + scheduling.getId();
        }
        
        return code;
    }
}
