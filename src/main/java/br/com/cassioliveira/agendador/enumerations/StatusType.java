package br.com.cassioliveira.agendador.enumerations;

import lombok.Getter;

/**
 * @author cassio
 */
public enum StatusType {
    FREE("Livre"),
    BUSY("Ocupado"),
    OPEN("Aberto"),
    CLOSE("Fechado");

    @Getter
    private final String description;

    StatusType(String description) {
        this.description = description;
    }
}
