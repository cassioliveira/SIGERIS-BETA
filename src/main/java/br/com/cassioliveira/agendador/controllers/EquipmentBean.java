package br.com.cassioliveira.agendador.controllers;

import br.com.cassioliveira.agendador.enumerations.EquipmentType;
import br.com.cassioliveira.agendador.model.Equipment;
import br.com.cassioliveira.agendador.services.EquipmentService;
import br.com.cassioliveira.agendador.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Cássio Oliveira
 */
@Named
@ViewScoped
public class EquipmentBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(EquipmentBean.class);

    @Inject
    @Getter
    @Setter
    private Equipment equipment;

    @Inject
    @Getter
    @Setter
    private EquipmentService equipmentService;

    @Inject
    @Getter
    @Setter
    private Equipment selectedEquipment;
    
    @Getter
    private List<Equipment> equipments;

    @Getter
    private List<EquipmentType> equipmentTypes;

    @PostConstruct
    public void init() {
        this.equipmentTypes = Arrays.asList(EquipmentType.values());
        this.equipments = equipmentService.findAll();
//        this.equipmentTypes = equipmentService.getEquipmentTypes();
    }

    public void save() {
        this.equipmentService.save(equipment);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro do " + equipment.getName() + " atualizado com sucesso!");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirectTo("listar-equipamentos.xhtml");
        equipment = new Equipment();
    }

    public void remove() {
        this.equipmentService.delete(selectedEquipment);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
        FacesUtil.redirectTo("listar-equipamentos.xhtml");
    }

    /**
     * Verifica se o objeto esta nulo quando for recuperado. Se sim, refere-se a
     * um novo cadastro, senao refere-se a um item a ser editado
     *
     * @return
     */
    public boolean getEditing() {
        return this.equipment.getId() != null;
    }

    public List<Equipment> getEquipmentsWithStoq() {
        return equipmentService.allEquipmentsWithStoq();
    }
}
