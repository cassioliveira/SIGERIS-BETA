package br.com.cassioliveira.agendador.repository;

import br.com.cassioliveira.agendador.model.Room;
import br.com.cassioliveira.agendador.model.Scheduling;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Schedulings extends Generic<Scheduling> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Schedulings() {
        super(Scheduling.class);
    }
    
    public List<Scheduling> scheduledRoom(){
        return getEntityManager().createNamedQuery("Scheduling.isRoomScheduled").getResultList();
    }
}
