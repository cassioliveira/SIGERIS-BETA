package br.com.cassioliveira.sigeris.model;

import br.com.cassioliveira.sigeris.enumerations.States;
import br.com.cassioliveira.sigeris.enumerations.WorkType;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author cassio
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NamedQuery(name = "Teacher.areas", query = "SELECT DISTINCT t.area FROM Teacher t")
public class Teacher extends Person implements Serializable {

    public static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "worktype")
    private WorkType workType;

    /*Aqui informa a área como Direito, Economia, Administração, etc.*/
    @Column(name = "area", length = 100)
    private String area;

    @Column(name = "function_description", length = 100)
    private String functionDescription;

    @Column(name = "is_function", length = 100)
    private boolean isFunction;

//    @OneToMany(targetEntity = Discipline.class, cascade = CascadeType.ALL)
//    @JoinTable(name = "teacher_discipline",
//            joinColumns = {
//                @JoinColumn(name = "teacher_id")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "discipline_id")})
//    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
//    private List<TeacherDiscipline> TeacherDisciplines;
    @PostConstruct
    public void init() {
        setUf(States.PB);
    }

}
