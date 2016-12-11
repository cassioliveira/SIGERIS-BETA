package br.com.cassioliveira.agendador.services;

import br.com.cassioliveira.agendador.model.Driver;
import br.com.cassioliveira.agendador.repository.Drivers;
import br.com.cassioliveira.agendador.repository.GlobalQueries;
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
public class DriverService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(DriverService.class);

    @Inject
    private Drivers drivers;

    @Inject
    @Getter
    private GlobalQueries globalQueries;

    @Transactional
    public void save(Driver driver) {
        this.drivers.save(driver);
    }

    @Transactional
    public void delete(Driver driver) {
        drivers.delete(findById(driver.getId()));
    }

    public Driver findById(Long id) {
        return drivers.findById(id);
    }

    public List<Driver> findAll() {
        return drivers.findAll();
    }

    public List<String> getCities(int ufCode) {
        return globalQueries.returnCities(ufCode);
    }
}
