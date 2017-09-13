package br.com.cassioliveira.sigeris.model;

import br.com.cassioliveira.sigeris.enumerations.WorkType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author cassio
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQuery(name = "Teacher.areas", query = "SELECT DISTINCT t.area FROM Teacher t")
public class Teacher extends Person implements Serializable {

    public static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "worktype")
    private WorkType workType;

    /*Aqui informa a área como Direito, Economia, Administração, etc.*/
    @Column(name = "area", length = 100)
    private String area;

}
