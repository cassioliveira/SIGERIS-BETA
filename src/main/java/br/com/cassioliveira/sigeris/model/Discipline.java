package br.com.cassioliveira.sigeris.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Data
@Entity
public class Discipline implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "discipline_code", length = 20)
    private String disciplineCode;

    @Column(name = "carga_horaria_semanal")
    private int cargaHorariaSemanal;

}
