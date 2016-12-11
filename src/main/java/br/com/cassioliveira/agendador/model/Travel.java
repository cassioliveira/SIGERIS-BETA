package br.com.cassioliveira.agendador.model;

import br.com.cassioliveira.agendador.enumerations.States;
import br.com.cassioliveira.agendador.enumerations.TravelReasons;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Embeddable
@Data
public class Travel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "reason")
    private TravelReasons reason;

    @Lob
    @Column(name = "reason_details")
    private String reasonDetails;

    @Column(name = "number_of_passengers")
    private int numberOfPassengers;

    @Column(name = "destination_distance")
    private Double distance;

    @Column(name = "origin_city", length = 100)
    private String originCity;

    @Enumerated(EnumType.STRING)
    @Column(name = "origin_uf")
    private States originUf;

    @Column(name = "origin_street", length = 100)
    private String originStreet;

    @Column(name = "dorigin_number", length = 50)
    private String originNumber;

    @Column(name = "origin_neighborhood", length = 250)
    private String originNeighborhood;

    @Column(name = "destination_city", length = 100)
    private String destinationCity;

    @Enumerated(EnumType.STRING)
    @Column(name = "destination_uf")
    private States uf;

    @Column(name = "destination_street", length = 100)
    private String destinationStreet;

    @Column(name = "destination_number", length = 50)
    private String destinationNumber;

    @Column(name = "destination_neighborhood", length = 250)
    private String destinationNeighborhood;

    @OneToOne
    @JoinColumn(name = "driverFK_id")
    private Driver driver;

//    @OneToOne(mappedBy = "travel")
//    @JoinColumn(name = "schedulingFK_id")
//    private Scheduling scheduling;
//    @OneToMany(mappedBy = "employee")
//    private List<Transport> transports;
//
//    @ManyToOne
//    private Driver driver;
//
//    @ManyToOne
//    private Responsible responsible;
}
