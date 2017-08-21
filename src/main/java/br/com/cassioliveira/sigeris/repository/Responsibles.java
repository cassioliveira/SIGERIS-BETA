package br.com.cassioliveira.sigeris.repository;

import br.com.cassioliveira.sigeris.model.Responsible;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Responsibles extends Generic<Responsible> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Responsibles() {
        super(Responsible.class);
    }
}
