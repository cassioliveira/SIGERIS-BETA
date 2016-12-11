package br.com.cassioliveira.agendador.repository;

import br.com.cassioliveira.agendador.model.Transport;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Transports extends Generic<Transport> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Transports() {
        super(Transport.class);
    }
}
