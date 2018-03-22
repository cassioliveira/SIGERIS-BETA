package br.com.cassioliveira.sigeris.model;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author cassio
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Requester extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

}
