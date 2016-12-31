package br.com.cassioliveira.agendador.repository;

import br.com.cassioliveira.agendador.model.Room;
import java.io.Serializable;
import java.util.List;

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
     * Retorna os números de todas as salas cadastradas no sistema.
     *
     * @return
     */
    public List<String> getRoomsNumber() {
        return getEntityManager().createNamedQuery("Room.roomsNumber").getResultList();
    }

    /**
     * Retorna apenas as salas que estão com status livre.
     *
     * @return
     */
    public List<Room> getFreeRooms() {
        return getEntityManager().createNamedQuery("Room.freeRooms").getResultList();
    }
}
