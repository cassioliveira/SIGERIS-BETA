package br.com.cassioliveira.sigeris.repository;

import br.com.cassioliveira.sigeris.model.Employee;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Employees extends Generic<Employee> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Employees() {
        super(Employee.class);
//        Teacher teacher = new Teacher();
    }

//    /**
//     * Retorna todas as áreas de conhecimento associadas ao professor cadastradas 
//     * @return 
//     */
//    public List<String> getTeacherAreas(){
//        return getEntityManager().createNamedQuery("Teacher.areas").getResultList();
//    }
//    
//    public List<String> getTeacherSituations(){
//        return getEntityManager().createNamedQuery("Teacher.situation").getResultList();
//    }
}
