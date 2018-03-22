package br.com.cassioliveira.sigeris.model;

import br.com.cassioliveira.sigeris.enumerations.Status;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * WHERE s.forecastSchedulingDateTime > CURRENT_TIMESTAMP
 *
 * @author cassio
 */
@Data
@Entity
@NamedQueries({
    @NamedQuery(name = "Scheduling.isRoomScheduled",
            query = "SELECT s FROM Scheduling s WHERE s.forecastSchedulingDateTime > CURRENT_TIMESTAMP")})
public class Scheduling implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 20)
    private String code;

    @Column(name = "type", length = 100)
    private String type;

    
    @Column(name = "observations")
    private String observations;

    /**
     * Data para início do scheduling
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "begining_date")
    private Date beginingSchedulingDateTime;

    /*
     * Data prevista para finalizar o agendamento
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "forecast_date")
    private Date forecastSchedulingDateTime;

    /**
     * Data em que o agendamento foi finalizado de fato
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ending_date")
    private Date endingSchedulingDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "reason", length = 150)
    private String schedulingReason;

    
    @Column(name = "file")
    private byte[] craft;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "equipmentfk_id")
    private Equipment equipment;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "roomfk_id")
    private Room room;

    @OneToOne
    @JoinColumn(name = "requesterfk_id")
    private Requester requester;

    @PostConstruct
    public void init() {
        if (id == null) {
            setRegisterDate(new Date());
        }
    }
}
