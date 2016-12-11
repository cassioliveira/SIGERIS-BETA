package br.com.cassioliveira.agendador.controllers;

import br.com.cassioliveira.agendador.enumerations.RoomsType;
import br.com.cassioliveira.agendador.model.Room;
import br.com.cassioliveira.agendador.services.RoomService;
import br.com.cassioliveira.agendador.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Cássio Oliveira
 */
@Model
public class RoomBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(RoomBean.class);

    @Inject
    @Getter
    @Setter
    private Room room;

    @Inject
    @Getter
    @Setter
    private RoomService roomService;

    @Inject
    @Getter
    @Setter
    private Room selectedRoom;

    @Getter
    private final List<RoomsType> roomTypes;

    private List<Room> rooms;

    public RoomBean() {
        roomTypes = Arrays.asList(RoomsType.values());
    }

    @PostConstruct
    public void init() {
        this.rooms = roomService.findAll();
    }

    public void save() {
        this.roomService.save(room);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro da room nº " + room.getNumber() + " atualizado com sucesso!");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirectTo("listar-salas.xhtml");
        room = new Room();
    }

    public void remove() {
        this.roomService.delete(selectedRoom);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.room.getId() != null;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }
}
