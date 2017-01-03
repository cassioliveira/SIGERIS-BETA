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
     * Retorna o apenas os equipamentos cadastrados que tẽm patrimônio
     *
     * @return
     */
    public List<String> getEquipmentByPatrimony() {
        return getEntityManager().createNamedQuery("Equipment.byPatrimony").getResultList();
    }

    /**
     * Verifica a quantidade disponível de um item e só retorna a lista com os
     * que tiverem uma quantidade maior que 0 (zero)
     *
     * @return
     */
    public List<Equipment> equipmentsWithStoq() {
        return getEntityManager().createNamedQuery("Equipment.isStoq").getResultList();
    }

    /**
     * Verifica se há equipamentos associadas a agendamentos ativos.
     *
     * @return
     */
//    public List<Equipment> scheduledEquipments() {
//        return getEntityManager().createNamedQuery("Equipment.isScheduled").getResultList();
//    }
}
