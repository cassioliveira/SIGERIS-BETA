package br.com.cassioliveira.sigeris.controllers;

import br.com.cassioliveira.sigeris.model.Employee;
import br.com.cassioliveira.sigeris.services.EmployeeService;
import br.com.cassioliveira.sigeris.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cássio Oliveira
 */
@Model
public class EmployeeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private Employee employee;

    @Inject
    @Getter
    @Setter
    private EmployeeService employeeService;

    @Inject
    @Getter
    @Setter
    private Employee selectedEmployee;

    private List<Employee> employees;

    @PostConstruct
    public void init() {
        this.employees = employeeService.findAll();
    }

    public void save() {
        this.employeeService.save(employee);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro do servidor " + employee.getName() + " atualizado com sucesso!");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirectTo("listar-servidores.xhtml");
        employee = new Employee();
    }

    public void remove() {
        this.employeeService.delete(selectedEmployee);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.employee.getId() != null;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }
}
