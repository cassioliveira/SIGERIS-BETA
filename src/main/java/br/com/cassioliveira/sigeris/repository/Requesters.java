package br.com.cassioliveira.sigeris.repository;

import br.com.cassioliveira.sigeris.model.Requester;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Requesters extends Generic<Requester> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Requesters() {
        super(Requester.class);
    }
}
