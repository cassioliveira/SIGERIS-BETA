package br.com.cassioliveira.sigeris.services;

import br.com.cassioliveira.sigeris.model.Employee;
import br.com.cassioliveira.sigeris.repository.Employees;
import br.com.cassioliveira.sigeris.repository.GlobalQueries;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
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

    @Inject
    @Getter
    private GlobalQueries globalQueries;

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

    public List<String> getCities(int ufCode) {
        return globalQueries.returnCities(ufCode);
    }

//    public List<String> getTeacherAreas() {
//        return employees.getTeacherAreas();
//    }
//    
//    public List<String> getTeacherSituations() {
//        return employees.getTeacherSituations();
//    }
}
