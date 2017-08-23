package br.com.cassioliveira.sigeris.controllers;


import br.com.cassioliveira.sigeris.model.Grupo;
import br.com.cassioliveira.sigeris.services.GroupService;
import br.com.cassioliveira.sigeris.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Cássio Oliveira
 */
@Model
public class GroupBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(GroupBean.class);

    @Inject
    @Getter
    @Setter
    private Grupo group;

    @Inject
    @Getter
    @Setter
    private GroupService groupService;

    @Inject
    @Getter
    @Setter
    private Grupo selectedGroup;

    private List<Grupo> groups;

    public GroupBean() {
    }

    @PostConstruct
    public void init() {
//        this.groups = groupService.gruposDeUsuarios();
    }

    public void save() {
        this.groupService.save(group);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro do grupo " + group.getName() + " atualizado com sucesso!");
            FacesUtil.redirectTo("SearchGroup.xhtml");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
            FacesUtil.redirectTo("cadastro-grupo.xhtml");
        }
        group = new Grupo();
    }

    public void remove() {
        this.groupService.delete(selectedGroup);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, se não, refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.group.getId() != null;
    }

    public List<Grupo> getGroups() {
        return this.groupService.gruposDeUsuarios();
    }
}
