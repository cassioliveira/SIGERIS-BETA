package br.com.cassioliveira.agendador.repository;

import br.com.cassioliveira.agendador.model.GroupType;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Groups extends Generic<GroupType> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Groups() {
        super(GroupType.class);
    }

}
