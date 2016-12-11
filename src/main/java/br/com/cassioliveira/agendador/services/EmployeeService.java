package br.com.cassioliveira.agendador.services;

import br.com.cassioliveira.agendador.model.Employee;
import br.com.cassioliveira.agendador.repository.Employees;
import br.com.cassioliveira.agendador.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
public class EmployeeService implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static final Log LOGGER = LogFactory.getLog(EmployeeService.class);

    @Inject
    private Employees employees;

    @Transactional
    public void save(Employee employee) {
        this.employees.save(employee);
    }

    @Transactional
    public void delete(Employee employee) {
        employees.delete(findById(employee.getId()));
    }

    public Employee findById(Long id) {
        return employees.findById(id);
    }

    public List<Employee> findAll() {
        return employees.findAll();
    }
}
