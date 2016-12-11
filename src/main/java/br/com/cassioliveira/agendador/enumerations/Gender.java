package br.com.cassioliveira.agendador.enumerations;

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
