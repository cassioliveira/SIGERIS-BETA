package br.com.cassioliveira.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum EmployeeCategory implements Serializable {

    EFETIVO("Efetivo"),
    SUBSTITUTO("Substituto"),
    VISITANTE("Visitante");

    @Getter
    private final String description;

    EmployeeCategory(String description) {
        this.description = description;
    }
}
