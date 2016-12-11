package br.com.cassioliveira.agendador.enumerations;

import lombok.Getter;

/**
 * @author cassio
 */
public enum SchedulingStatus {

    OPEN("Aberto"),
    CLOSE("Fechado");

    @Getter
    private final String description;

    SchedulingStatus(String description) {
        this.description = description;
    }
}
