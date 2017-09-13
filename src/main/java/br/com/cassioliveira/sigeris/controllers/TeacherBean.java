package br.com.cassioliveira.sigeris.controllers;

import br.com.cassioliveira.sigeris.enumerations.EmployeeCategory;
import br.com.cassioliveira.sigeris.enumerations.EmployeeSituation;
import br.com.cassioliveira.sigeris.enumerations.Gender;
import br.com.cassioliveira.sigeris.enumerations.States;
import br.com.cassioliveira.sigeris.enumerations.WorkType;
import br.com.cassioliveira.sigeris.model.Teacher;
import br.com.cassioliveira.sigeris.services.TeacherService;
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
public class TeacherBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private Teacher teacher;

    @Inject
    @Getter
    @Setter
    private TeacherService teacherService;

    @Inject
    @Getter
    @Setter
    private Teacher selectedTeacher;

    private List<Teacher> teachers;

    @Getter
    private List<Gender> genders;

    @Getter
    private List<WorkType> workTypes;

    @Getter
    private List<EmployeeSituation> employeeSituations;
    
    @Getter
    private List<EmployeeCategory> employeeCategories;

    @Getter
    private List<String> teacherAreas;

    @Getter
    private final List<String> cities = new ArrayList<>();

    @Getter
    private List<States> states = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.states = Arrays.asList(States.values());
        this.workTypes = Arrays.asList(WorkType.values());
        this.genders = Arrays.asList(Gender.values());
        this.employeeSituations = Arrays.asList(EmployeeSituation.values());
        this.employeeCategories = Arrays.asList(EmployeeCategory.values());
        this.teachers = teacherService.findAll();
        this.teacherAreas = teacherService.getTeacherAreas();
    }

    public void save() {
        this.teacherService.save(teacher);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro do servidor " + teacher.getName() + " atualizado com sucesso!");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirectTo("listar-servidores.xhtml");
        teacher = new Teacher();
    }

    public void remove() {
        this.teacherService.delete(selectedTeacher);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
    }

    /**
     * Método que carrega uma lista de cidades de acordo com o estado
     * selecionado.
     */
    public void returnCities() {
        this.cities.clear();
        if (teacher.getUf() != null) {
            for (String filteredCities : teacherService.getCities(teacher.getUf().getCode())) {
                this.cities.add(filteredCities);
            }
        }
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.teacher.getId() != null;
    }

    public List<Teacher> getTeachers() {
        return this.teachers;
    }
}
