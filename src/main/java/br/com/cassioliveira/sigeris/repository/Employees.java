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
    }
}
