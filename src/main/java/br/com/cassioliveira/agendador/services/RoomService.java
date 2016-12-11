package br.com.cassioliveira.agendador.services;

import br.com.cassioliveira.agendador.exceptions.BusinessException;
import br.com.cassioliveira.agendador.model.Room;
import br.com.cassioliveira.agendador.repository.Rooms;
import br.com.cassioliveira.agendador.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
public class RoomService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(RoomService.class);

    @Inject
    private Rooms rooms;

    @Transactional
    public void save(Room room) {
        if (room.getId() == null && isRoomDuplicated(room.getNumber())) {
            throw new BusinessException("Room com esse nome/número já existe. Por favor informe outro");
        } else {
            this.rooms.save(room);
        }
    }

    @Transactional
    public void delete(Room room) {
        rooms.delete(findById(room.getId()));
    }

    public Room findById(Long id) {
        return rooms.findById(id);
    }

    public List<Room> findAll() {
        return rooms.findAll();
    }

    /**
     * Metodo que verifica se a room que está sendo informada já existe no
     * sistema baseada no nome da mesma, que não pode ser repetida.
     *
     * @param room
     * @return
     */
    public boolean isRoomDuplicated(String room) {
        for (String selectedRoom : rooms.roomNameOrNumber()) {
            if (selectedRoom.equals(room)) {
                return true;
            }
        }
        return false;
    }
}
