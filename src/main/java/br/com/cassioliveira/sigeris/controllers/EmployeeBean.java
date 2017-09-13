package br.com.cassioliveira.sigeris.controllers;

import br.com.cassioliveira.sigeris.enumerations.Gender;
import br.com.cassioliveira.sigeris.enumerations.States;
import br.com.cassioliveira.sigeris.enumerations.WorkType;
import br.com.cassioliveira.sigeris.model.Employee;
import br.com.cassioliveira.sigeris.services.EmployeeService;
import br.com.cassioliveira.sigeris.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Getter
    private List<Gender> genders;

    @Getter
    private List<WorkType> workTypes;

    @Getter
    private List<String> teacherAreas;

    @Getter
    private List<String> teacherSituations;

    @Getter
    private final List<String> cities = new ArrayList<>();

    @Getter
    private List<States> states = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.states = Arrays.asList(States.values());
        this.workTypes = Arrays.asList(WorkType.values());
        this.genders = Arrays.asList(Gender.values());
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

    /**
     * Método que carrega uma lista de cidades de acordo com o estado
     * selecionado.
     */
    public void returnCities() {
        this.cities.clear();
        if (employee.getUf() != null) {
            employeeService.getCities(employee.getUf().getCode()).forEach((filteredCities) -> {
                this.cities.add(filteredCities);
            });
        }
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
