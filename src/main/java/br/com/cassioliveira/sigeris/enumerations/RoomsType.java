package br.com.cassioliveira.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum RoomsType implements Serializable {

    LABORATORY("Laboratório"),
    AUDITORIUM("Auditório"),
    CLASSROOM("Sala de aula"),
    VIDEOROOM("Sala de vídeo"),
    OTHER("Outro");

    @Getter
    private final String description;

    RoomsType(String description) {
        this.description = description;
    }
}
