package br.com.cassioliveira.agendador.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Entity
@Data
@Table(name = "group_type")
public class GroupType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name", length = 200, nullable = false)
    private String name;

    @Column(name = "group_description", length = 20)
    private String description;

}
