package br.com.cassioliveira.sigeris.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author cassio
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Teacher extends Person implements Serializable {

    public static final long serialVersionUID = 1L;

    @Column(name = "timejob")
    private int timeJob;

    @Column(name = "worktype", length = 5)
    private String workType;

    @Lob
    @Column(name = "observations")
    private String observations;
}
