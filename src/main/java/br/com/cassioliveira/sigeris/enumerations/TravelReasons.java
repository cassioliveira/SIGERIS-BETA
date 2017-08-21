package br.com.cassioliveira.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum TravelReasons implements Serializable {

    ADMINISTRATIVO("Administrativo"),
    PEGARMATERIALEXPEDIENTE("Pegar meterial de expediente"),
    CONSERTOEQUIPAMENTO("Levar equipment para conserto"),
    CONGRESSO("Congresso"),
    SIMPOSIO("Simpósio"),
    ENCONTRO("Encontro"),
    PROVA("Prova"),
    OTHER("Outro");

    @Getter
    private final String description;

    TravelReasons(String description) {
        this.description = description;
    }
}
