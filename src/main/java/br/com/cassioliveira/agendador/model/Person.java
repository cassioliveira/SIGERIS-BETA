package br.com.cassioliveira.agendador.model;

import br.com.cassioliveira.agendador.enumerations.Gender;
import br.com.cassioliveira.agendador.enumerations.States;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_name", length = 200, nullable = false)
    private String name;

    @Column(name = "person_registration", length = 20)
    private String registration;

    @Enumerated(EnumType.STRING)
    @Column(name = "person_gender")
    private Gender gender;

    @Column(name = "person_cpf", length = 11, nullable = false)
    private String cpf;

    @Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
            message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
    @Column(name = "person_rg", length = 100)
    private String rg;

    @Column(name = "address_street", length = 100)
    private String street;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_uf")
    private States uf;

    @Column(name = "address_neighborhood", length = 50)
    private String neighborhood;

    @Column(name = "address_number", length = 5)
    private int number;

    @Column(name = "address_city", length = 70)
    private String city;

    @Column(name = "address_postal_code", length = 10)
    private String postalCode;

    @Column(name = "person_phone1", length = 15)
    private String phone1;

    @Column(name = "person_phone2", length = 15)
    private String phone2;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "person_email", length = 100)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "person_birth_date")
    private Date birthDate;
}
