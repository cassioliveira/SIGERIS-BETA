package br.com.cassioliveira.sigeris.model;

import br.com.cassioliveira.sigeris.enumerations.Courses;
import br.com.cassioliveira.sigeris.enumerations.RoomsType;
import br.com.cassioliveira.sigeris.enumerations.Status;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Data
@Entity
@NamedQueries({
    @NamedQuery(name = "Room.freeRooms", query = "SELECT r FROM Room AS r WHERE r.status = br.com.cassioliveira.sigeris.enumerations.Status.FREE"),
    @NamedQuery(name = "Room.roomsNumber", query = "SELECT r.number FROM Room as r")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "number")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RoomsType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "associated_course")
    private Courses associatedCourse;

    @Column(name = "is_air_conditioning")
    private boolean airConditioning;

    @Column(name = "is_computer")
    private boolean computer;

    @Column(name = "is_datashow")
    private boolean datashow;

    @Column(name = "is_microphone")
    private boolean microphone;

    @Column(name = "is_internet")
    private boolean internet;

    @Column(name = "is_board")
    private boolean board;

    @Column(name = "is_dvd")
    private boolean dvd;

    @Column(name = "is_tv")
    private boolean tv;

    @Column(name = "is_fan")
    private boolean fan;

    @Column(name = "is_sound")
    private boolean sound;

    @Lob
    @Column(name = "observations")
    private String observations;

    @Column(name = "capacity")
    private Integer capacity;
}
