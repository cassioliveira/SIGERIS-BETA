package br.com.cassioliveira.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum Gender implements Serializable {

    M("Masculino"),
    F("Feminino");

    @Getter
    private final String description;

    Gender(String description) {
        this.description = description;
    }
}
