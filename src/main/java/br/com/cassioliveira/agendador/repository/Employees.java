package br.com.cassioliveira.agendador.repository;

import br.com.cassioliveira.agendador.model.Employee;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Employees extends Generic<Employee> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Employees() {
        super(Employee.class);
    }
}
