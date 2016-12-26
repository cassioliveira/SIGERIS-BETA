package br.com.cassioliveira.agendador.repository;

import br.com.cassioliveira.agendador.model.Room;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Rooms extends Generic<Room> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Rooms() {
        super(Room.class);
    }

    /**
     * Método que retorna o número de todas as rooms cadastradas no sistema.
     *
     * @return
     */
    public List<String> roomNameOrNumber() {
        Query createQuery;

        createQuery = getEntityManager().createNativeQuery("SELECT r.number FROM room as r");
        return createQuery.getResultList();
    }
}
