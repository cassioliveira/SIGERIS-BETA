package br.com.cassioliveira.agendador.model;

import java.io.Serializable;
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
public class Responsible extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

}
