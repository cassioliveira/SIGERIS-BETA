package br.com.cassioliveira.agendador.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 * @author cassio
 */
public enum SchedulingTypes implements Serializable {

    ROOM("Room"),
    TRAVEL("Travel"),
    EQUIPMENT("Equipment");

    @Getter
    private final String description;

    SchedulingTypes(String description) {
        this.description = description;
    }
}
