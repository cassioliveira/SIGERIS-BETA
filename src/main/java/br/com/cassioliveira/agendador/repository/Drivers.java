package br.com.cassioliveira.agendador.repository;

import br.com.cassioliveira.agendador.model.Driver;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Drivers extends Generic<Driver> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Drivers() {
        super(Driver.class);
    }
    
//    public List<String> getCities(int ufCode) {
//        Query createQuery;
//        createQuery = getEntityManager().createNativeQuery("SELECT c.nome FROM cidades c where c.estado = " + ufCode);
//        return createQuery.getResultList();
//    }
}
