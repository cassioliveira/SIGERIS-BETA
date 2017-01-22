package br.com.cassioliveira.agendador.enumerations;

import lombok.Getter;

/**
 * @author cassio
 */
public enum Courses {
    LETRAS("Letras"),
    CONTABEIS("Ciencias Contábeis"),
    MATEMATICA("Matemática");

    @Getter
    private final String description;

    Courses(String description) {
        this.description = description;
    }
}
