package br.com.cassioliveira.sigeris.repository;

import br.com.cassioliveira.sigeris.model.Discipline;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Disciplines extends Generic<Discipline> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Disciplines() {
        super(Discipline.class);
    }
}
