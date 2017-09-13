package br.com.cassioliveira.sigeris.repository;

import br.com.cassioliveira.sigeris.model.Teacher;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Teachers extends Generic<Teacher> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Teachers() {
        super(Teacher.class);
//        Teacher teacher = new Teacher();
    }
    
    /**
     * Retorna todas as áreas de conhecimento associadas ao professor cadastradas 
     * @return 
     */
    public List<String> getTeacherAreas(){
        return getEntityManager().createNamedQuery("Teacher.areas").getResultList();
    }
}
