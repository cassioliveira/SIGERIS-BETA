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
public class Enterprise extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "nick_name")
    private String nickName;

}
