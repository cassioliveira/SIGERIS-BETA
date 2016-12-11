package br.com.cassioliveira.agendador.model;

import br.com.cassioliveira.agendador.enumerations.CarsTypes;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Entity
@Data
public class Transport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "brand", length = 50)
    private CarsTypes brand;

    @Column(name = "model", length = 50)
    private String model;

    @Column(name = "plaque", length = 10, nullable = false)
    private String plaque;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "maximum_capacity")
    private Integer maximumCapacity;

    @Column(name = "year")
    private Integer year;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_time")
    private Date dateTime;

//    @ManyToOne
//    private Employee employee;
//
//    @ManyToOne
//    private Travel travel;
}
