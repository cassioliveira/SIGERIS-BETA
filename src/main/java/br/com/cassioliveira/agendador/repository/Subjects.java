package br.com.cassioliveira.agendador.repository;

import br.com.cassioliveira.agendador.model.Subject;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Subjects extends Generic<Subject> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Subjects() {
        super(Subject.class);
    }

    /**
     * Método que faz uma consulta por um usuário no banco de dados e retorna o
     * mesmo baseado no parametro do método
     *
     * @param userName
     * @return
     */
    public Subject byUser(String userName) {

        return (Subject) getEntityManager().createNamedQuery("Subject.byUser").setParameter("userName", userName.toLowerCase()).getSingleResult();
        
//        Query query;
//        query = getEntityManager().createQuery("FROM Subject AS s WHERE s.user = :user", Subject.class)
//                .setParameter("user", user.toLowerCase());
//        return (Subject) query.getSingleResult();
    }
}
