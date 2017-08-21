package br.com.cassioliveira.sigeris.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author cassio
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "department", length = 100)
    private String department;

//    @OneToMany(mappedBy = "employee")
//    private List<Driver> drivers;
//
//    @OneToMany(mappedBy = "employee")
//    private List<Responsible> responsibles;
//
//    @OneToMany(mappedBy = "employee")
//    private List<Room> rooms;
//
//    @OneToMany(mappedBy = "employee")
//    private List<Scheduling> schedulings;
//
//    @OneToMany(mappedBy = "employee")
//    private List<Transport> transports;
}
