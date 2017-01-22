package br.com.cassioliveira.agendador.enumerations;

import lombok.Getter;

/**
 * @author cassio
 */
public enum Status {
    FREE("Livre"),
    BUSY("Ocupado"),
    OPEN("Aberto"),
    CLOSE("Fechado");

    @Getter
    private final String description;

    Status(String description) {
        this.description = description;
    }
}
