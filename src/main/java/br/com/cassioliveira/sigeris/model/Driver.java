package br.com.cassioliveira.sigeris.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author cassio
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Driver extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "licence", length = 100)
    private String licence;

    @Column(name = "licence_category", length = 10)
    private String licenceCategory;

    @Temporal(TemporalType.DATE)
    @Column(name = "licence_expiration")
    private Date licenceExpiration;

}
