package br.com.cassioliveira.sigeris.services;

import br.com.cassioliveira.sigeris.model.Transport;
import br.com.cassioliveira.sigeris.repository.Transports;
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
public class TransportService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(TransportService.class);

    @Inject
    private Transports transports;

    @Transactional
    public void save(Transport transport) {
        this.transports.save(transport);
    }

    @Transactional
    public void delete(Transport transport) {
        transports.delete(findById(transport.getId()));
    }

    public Transport findById(Long id) {
        return transports.findById(id);
    }

    public List<Transport> findAll() {
        return transports.findAll();
    }
}
