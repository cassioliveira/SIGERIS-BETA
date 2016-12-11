package br.com.cassioliveira.agendador.services;

import br.com.cassioliveira.agendador.model.Responsible;
import br.com.cassioliveira.agendador.repository.GlobalQueries;
import br.com.cassioliveira.agendador.repository.Responsibles;
import br.com.cassioliveira.agendador.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
public class ResponsibleService implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static final Log LOGGER = LogFactory.getLog(ResponsibleService.class);

    @Inject
    private Responsibles responsibles;
    
    @Inject
    @Getter
    private GlobalQueries globalQueries;

    @Transactional
    public void save(Responsible responsible) {
        this.responsibles.save(responsible);
    }

    @Transactional
    public void delete(Responsible responsible) {
        responsibles.delete(findById(responsible.getId()));
    }

    public Responsible findById(Long id) {
        return responsibles.findById(id);
    }

    public List<Responsible> findAll() {
        return responsibles.findAll();
    }
    
    public List<String> getCities(int ufCode) {
        return globalQueries.returnCities(ufCode);
    }
}
