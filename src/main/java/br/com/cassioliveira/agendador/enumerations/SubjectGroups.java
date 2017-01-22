package br.com.cassioliveira.agendador.enumerations;

import lombok.Getter;

/**
 * @author cassio
 */
public enum SubjectGroups {
    ADMINISTRADORES("Administradores"),
    SECRETARIOS("Secretarios"),
    COORDENADORES("Coordenadores"),
    DIRECAO("Direção"),
    VIGILANTES("Vigilantes"),
    TERCEIRIZADOS("Terceirizados"),
    BIBLIOTECA("Biblioteca");

    @Getter
    private final String description;

    SubjectGroups(String description) {
        this.description = description;
    }
}
