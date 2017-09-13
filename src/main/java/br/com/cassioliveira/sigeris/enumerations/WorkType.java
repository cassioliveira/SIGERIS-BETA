package br.com.cassioliveira.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum WorkType implements Serializable {

    T20("T-20"),
    T40("T-40");

    @Getter
    private final String description;

    WorkType(String description) {
        this.description = description;
    }
}
