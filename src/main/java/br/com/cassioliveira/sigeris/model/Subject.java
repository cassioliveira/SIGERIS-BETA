package br.com.cassioliveira.sigeris.model;

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
import javax.persistence.NamedQuery;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Data
@Entity
@NamedQuery(name = "Subject.byUser", query = "FROM Subject AS s WHERE s.userName = :userName")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
//    @SequenceGenerator(name = "seq_subject", sequenceName = "seq_subject", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", length = 200, nullable = false)
    private String userName;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "subject_group", joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Grupo> groups = new ArrayList<>();
}
