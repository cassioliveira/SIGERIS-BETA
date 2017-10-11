package br.com.cassioliveira.sigeris.model;

import br.com.cassioliveira.sigeris.enumerations.States;
import br.com.cassioliveira.sigeris.enumerations.WorkType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author cassio
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQuery(name = "Teacher.areas", query = "SELECT DISTINCT t.area FROM Teacher t")
public class Teacher extends Person implements Serializable {

    public static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "worktype")
    private WorkType workType;

    /*Aqui informa a área como Direito, Economia, Administração, etc.*/
    @Column(name = "area", length = 100)
    private String area;

//    @OneToMany(targetEntity = Discipline.class, cascade = CascadeType.ALL)
    
//    @JoinTable(name = "teacher_discipline",
//            joinColumns = {
//                @JoinColumn(name = "teacher_id")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "discipline_id")})
    @ManyToMany
    private List<Discipline> disciplines;

    /**
     * @return the workType
     */
    public WorkType getWorkType() {
        return workType;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @return the disciplines
     */
    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    @PostConstruct
    public void init() {
        setUf(States.PB);
    }

}
