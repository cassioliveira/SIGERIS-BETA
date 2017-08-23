package br.com.cassioliveira.sigeris.repository;

import br.com.cassioliveira.sigeris.model.Grupo;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Groups extends Generic<Grupo> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Groups() {
        super(Grupo.class);
    }

    /**
     * Retorna todos os grupos cadastrados na tabela @see Grupo.
     * @return 
     */
    public List<Grupo> gruposDeUsuarios(){
        return getEntityManager().createNamedQuery("Grupo.todos").getResultList();
    }
    
}
