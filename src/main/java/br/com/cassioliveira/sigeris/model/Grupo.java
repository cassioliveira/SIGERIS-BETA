package br.com.cassioliveira.sigeris.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Data
@Entity
@NamedQuery(name = "Grupo.todos", query = "SELECT g.name FROM Grupo g")
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
//    @SequenceGenerator(name = "seq_group", sequenceName = "seq_group", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_group")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "group_name", length = 30, nullable = false)
    private String name;
    
//    @Column(name = "alias_group_name", length = 50, nullable = false)
//    private String aliasGroupName;
}
