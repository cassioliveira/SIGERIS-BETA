package br.com.cassioliveira.sigeris.model;

import br.com.cassioliveira.sigeris.enumerations.EquipmentType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Data
@Entity
@NamedQueries({
    @NamedQuery(name = "Equipment.isStoq",
            query = "SELECT e FROM Equipment AS e WHERE e.quantity > 0")
    ,
//    @NamedQuery(name = "Equipment.isScheduled",
//            query = "SELECT e FROM Equipment AS e WHERE e.id = (SELECT s.equipment.id FROM Scheduling AS s)")
//    ,
    @NamedQuery(name = "Equipment.byPatrimony",
            query = "SELECT e.patrimony FROM Equipment AS e WHERE e.patrimony IS NOT NULL")})
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "other_type")
    private String otherType;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @NotNull(message = "Deve informar o tipo do item a ser cadastrado")
    private EquipmentType type;

    @Column(name = "patrimony", length = 20)
    private String patrimony;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "sector", length = 100)
    private String sector;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_date")
    private Date registerDate;

    
    @Column(name = "observations")
    private String observations;

    @OneToOne
    @JoinColumn(name = "schedulingfk_id")
    private Scheduling scheduling;

}
