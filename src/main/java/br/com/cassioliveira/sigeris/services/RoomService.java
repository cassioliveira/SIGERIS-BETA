package br.com.cassioliveira.sigeris.services;

import br.com.cassioliveira.sigeris.enumerations.Status;
import br.com.cassioliveira.sigeris.model.Room;
import br.com.cassioliveira.sigeris.repository.Rooms;
import br.com.cassioliveira.sigeris.util.jpa.Transactional;
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
            room.setStatus(Status.FREE);
            this.rooms.save(room);
//        if (isRoomDuplicated(room.getNumber()) && room.getId() == null) {
//            throw new BusinessException("Uma sala com esse nome/número já existe");
//        } else {
//        }
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
    
    public List<Room> getFreeRooms(){
        return rooms.getFreeRooms();
    }
    
    /**
     * Metodo que verifica se a sala que está sendo informada já existe no
     * sistema baseada no nome da mesma, que não pode ser repetida.
     *
     * @param room
     * @return
     */
//    public boolean isRoomDuplicated(String room) {
//        for (String selectedRoom : rooms.getRoomsNumber()) {
//            if (selectedRoom.equals(room)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
