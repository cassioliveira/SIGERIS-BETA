package br.com.cassioliveira.sigeris.services;

import br.com.cassioliveira.sigeris.model.Requester;
import br.com.cassioliveira.sigeris.repository.GlobalQueries;
import br.com.cassioliveira.sigeris.repository.Requesters;
import javax.transaction.Transactional;
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
public class RequesterService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(RequesterService.class);

    @Inject
    private Requesters requesters;

    @Inject
    @Getter
    private GlobalQueries globalQueries;

    @Transactional
    public void save(Requester requester) {
        this.requesters.save(requester);
    }

    @Transactional
    public void delete(Requester requester) {
        requesters.delete(findById(requester.getId()));
    }

    public Requester findById(Long id) {
        return requesters.findById(id);
    }

    public List<Requester> findAll() {
        return requesters.findAll();
    }

    public List<String> getCities(int ufCode) {
        return globalQueries.returnCities(ufCode);
    }
}
