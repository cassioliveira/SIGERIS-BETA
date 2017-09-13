package br.com.cassioliveira.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum EmployeeSituation implements Serializable {

    ATIVO("Ativo"),
    INATIVO("Inativo"),
    AFASTAMENTO("Afastamento"),
    LICENCA("Licença"),
    OTHER("Outro");

    @Getter
    private final String description;

    EmployeeSituation(String description) {
        this.description = description;
    }
}
