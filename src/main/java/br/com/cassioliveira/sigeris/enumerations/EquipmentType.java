package br.com.cassioliveira.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum EquipmentType implements Serializable {

    DATASHOW("Datashow"),
    NOTEBOOK("Notebook"),
    ESTABILIZATOR("Estabilizador"),
    ADAPTER("Adaptador"),
    CABLE("Cabo"),
    SOUND("Som"),
    ESTENSION("Extensão"),
    OTHER("Outro");

    @Getter
    private final String description;

    EquipmentType(String description) {
        this.description = description;
    }
}
