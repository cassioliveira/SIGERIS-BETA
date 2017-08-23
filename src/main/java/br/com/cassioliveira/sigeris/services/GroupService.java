package br.com.cassioliveira.sigeris.services;

import br.com.cassioliveira.sigeris.model.Grupo;
import br.com.cassioliveira.sigeris.repository.Groups;
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
public class GroupService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(GroupService.class);

    @Inject
    private Groups groups;

    @Transactional
    public void save(Grupo group) {
        this.groups.save(group);
    }

    @Transactional
    public void delete(Grupo group) {
        groups.delete(findById(group.getId()));
    }

    public Grupo findById(Long id) {
        return groups.findById(id);
    }

    public List<Grupo> findAll() {
        return groups.findAll();
    }
    
    public List<Grupo> gruposDeUsuarios(){
        return groups.gruposDeUsuarios();
    }
}
