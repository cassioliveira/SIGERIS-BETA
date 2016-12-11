package br.com.cassioliveira.agendador.model;

import br.com.cassioliveira.agendador.enumerations.EquipmentType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Embeddable
@Data
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "equipment_type", length = 50)
    private EquipmentType equipmentType;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "patrimony", length = 20)
    private String patrimony;

    @Lob
    @Column(name = "equipment_observations")
    private String observations;
}
