package br.com.cassioliveira.agendador.model;

import br.com.cassioliveira.agendador.enumerations.SchedulingStatus;
import br.com.cassioliveira.agendador.enumerations.SchedulingTypes;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Entity
@Data
public class Scheduling implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 20)
    private String code;

    @Column(name = "type", length = 100)
    private String type;

    @Lob
    @Column(name = "observations")
    private String observations;

    /**
     * Data para determinar o início do scheduling
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "begining_date")
    private Date beginingSchedulingDateTime;

    /**
     * Data para determinar o final do scheduling
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ending_date")
    private Date endingSchedulingDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "reason", length = 150)
    private String schedulingReason;

    @Lob
    @Column(name = "file")
    private byte[] craft;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SchedulingStatus status;
    
    @OneToOne
    @JoinColumn(name = "equipmentFK_id")
    private Equipment equipment;

    @OneToOne
    @JoinColumn(name = "roomFK_id")
    private Room room;

    @OneToOne
    @JoinColumn(name = "responsibleFK_id")
    private Responsible responsible;

//   @PostConstruct
//   public void init(){
//       setStatus(SchedulingStatus.OPEN);
//   }
}
