package br.com.cassioliveira.sigeris.model;

import br.com.cassioliveira.sigeris.enumerations.States;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author cassio
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Enterprise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

//    @Embedded
//    private Address address;
    
    @Column(name = "address_street", length = 100)
    private String street;

    @Column(name = "address_number", length = 5)
    private int number;

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
            message = "E-mail inválido")
    @Column(name = "email", length = 100)
    private String email;

}
