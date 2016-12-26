package br.com.cassioliveira.agendador.repository;

import br.com.cassioliveira.agendador.enumerations.EquipmentType;
import br.com.cassioliveira.agendador.model.Equipment;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Equipments extends Generic<Equipment> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Equipments() {
        super(Equipment.class);
    }

    /**
     * Método que retorna todos os tipos de equipamento armazenados na tabela de
     * equipamento.
     *
     * @return
     */
    public List<EquipmentType> getEquipmentTypes() {
        return getEntityManager().createNamedQuery("Equipment.types").getResultList();
    }

    /**
     * Método que retorna o apenas os equipamentos cadastrados que tẽm
     * patrimônio
     *
     * @return
     */
    public List<String> getEquipmentByPatrimony() {
        return getEntityManager().createNamedQuery("Equipment.byPatrimony").getResultList();
    }

}
