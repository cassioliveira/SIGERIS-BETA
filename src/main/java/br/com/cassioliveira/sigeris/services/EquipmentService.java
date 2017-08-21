package br.com.cassioliveira.sigeris.services;

import br.com.cassioliveira.sigeris.enumerations.EquipmentType;
import br.com.cassioliveira.sigeris.model.Equipment;
import br.com.cassioliveira.sigeris.repository.Equipments;
import br.com.cassioliveira.sigeris.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
public class EquipmentService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(EquipmentService.class);

    @Inject
    private Equipments equipments;

    @Transactional
    public void save(Equipment equipment) {
        this.equipments.save(equipment);
//        if (isEquipmentDuplicated(equipment.getPatrimony())) {
//            throw new BusinessException("Um item com esse patrimônio já existe.");
//        } else {
//        }
    }

    @Transactional
    public void delete(Equipment equipment) {
        equipments.delete(findById(equipment.getId()));
    }

    public Equipment findById(Long id) {
        return equipments.findById(id);
    }

    public List<Equipment> findAll() {
        return equipments.findAll();
    }

    public List<Equipment> allEquipmentsWithStoq() {
        return equipments.equipmentsWithStoq();
    }

//    /**
//     * Metodo que verifica se o equipamento que está sendo informado já existe
//     * no sistema baseada no patrimonio do mesmo, que não pode ser repetido.
//     *
//     * @param equipment
//     * @return
//     */
//    public boolean isEquipmentDuplicated(String equipment) {
//        return equipments.getEquipmentByPatrimony().stream().anyMatch((selectedEquipment) -> (selectedEquipment.equals(equipment)));
//    }
    public List<EquipmentType> getEquipmentTypes() {
        return equipments.getEquipmentTypes();
    }

}

///**
//     * Metodo que verifica se a equipment que está sendo informada já existe no
//     * sistema baseada no nome da mesma, que não pode ser repetida.
//     *
//     * @param equipment
//     * @return
//     */
//    public boolean isEquipmentDuplicated(String equipment) {
//        for (String selectedEquipment : equipments.getEquipmentByPatrimony()) {
//            if (selectedEquipment.equals(equipment)) {
//                return true;
//            }
//        }
//        return false;
//    }
