package br.com.cassioliveira.sigeris.services;

//package br.com.cassioliveira.sigeris.services;
//
//import br.com.cassioliveira.sigeris.exceptions.BusinessException;
//import br.com.cassioliveira.sigeris.model.EquipmentType;
//import br.com.cassioliveira.sigeris.repository.EquipmentTypes;
//import br.com.cassioliveira.sigeris.util.jpa.Transactional;
//import java.io.Serializable;
//import java.util.List;
//import javax.inject.Inject;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
///**
// *
// * @author elisangela
// */
//public class EquipmentTypeTypeService implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    private static final Log LOGGER = LogFactory.getLog(EquipmentTypeTypeService.class);
//
//    @Inject
//    private EquipmentTypes equipmentTypes;
//
//    @Transactional
//    public void save(EquipmentType equipmentType) {
//        if (equipmentType.getId() != null && isEquipmentTypeDuplicated(equipmentType.getPatrimony())) {
//            throw new BusinessException("Um item com esse patrimônio já existe.");
//        } else {
//            this.equipmentTypes.save(equipmentType);
//        }
//    }
//
//    @Transactional
//    public void delete(EquipmentType equipmentType) {
//        equipmentTypes.delete(findById(equipmentType.getId()));
//    }
//
//    public EquipmentType findById(Long id) {
//        return equipmentTypes.findById(id);
//    }
//
//    public List<EquipmentType> findAll() {
//        return equipmentTypes.findAll();
//    }
//
//    /**
//     * Metodo que verifica se a equipmentType que está sendo informada já existe no
//     * sistema baseada no nome da mesma, que não pode ser repetida.
//     *
//     * @param equipmentType
//     * @return
//     */
//    public boolean isEquipmentTypeDuplicated(String equipmentType) {
//        for (String selectedEquipmentType : equipmentTypes.getEquipmentTypeByPatrimony()) {
//            if (selectedEquipmentType.equals(equipmentType)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public List<String> getEquipmentTypeTypes() {
//        return equipmentTypes.getEquipmentTypeTypes();
//    }
//}
