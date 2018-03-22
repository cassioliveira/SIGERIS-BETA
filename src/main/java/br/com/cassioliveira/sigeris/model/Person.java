package br.com.cassioliveira.sigeris.model;

import br.com.cassioliveira.sigeris.enumerations.EmployeeCategory;
import br.com.cassioliveira.sigeris.enumerations.EmployeeSituation;
import br.com.cassioliveira.sigeris.enumerations.Gender;
import br.com.cassioliveira.sigeris.enumerations.States;
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
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*Aqui é algo como o cargo*/
    @Column(name = "job_role", length = 50)
    private String role;

    /*Aqui informa se tem função, como coordenador/adjunto, diretor/adjunto, etc.*/
//    @Column(name = "job_function", length = 50)
//    private List<String> jobFunction;
//    @Column(name = "sector", length = 100)
//    private List<String> sector;
    @NotNull
    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "registration", length = 20)
    private String registration;

    @Enumerated(EnumType.STRING)
    @Column(name = "situation")
    private EmployeeSituation situation;

    @Column(name = "other_situation", length = 200)
    private String otherSituation;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private EmployeeCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
            message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
    @Column(name = "rg", length = 100)
    private String rg;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "address_street", length = 200)
    private String street;

    @Column(name = "address_complement", length = 200)
    private String complement;

    @Column(name = "address_number", length = 10)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_uf")
    private States uf;

    @Column(name = "address_neighborhood", length = 50)
    private String neighborhood;

    @Column(name = "address_city", length = 70)
    private String city;

    @Column(name = "address_postal_code", length = 10)
    private String postalCode;

    @Column(name = "phone1", length = 15)
    private String phone1;

    @Column(name = "phone2", length = 15)
    private String phone2;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "email", length = 100)
    private String email;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "email2", length = 100)
    private String email2;

    
    @Column(name = "observations")
    private String observations;

}
