package br.com.cassioliveira.agendador.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Entity
@Data
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name", length = 200, nullable = false)
    private String user;

    @Column(name = "subject_password", length = 20, nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subject_group", joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<GroupType> groups = new ArrayList<>();

}
