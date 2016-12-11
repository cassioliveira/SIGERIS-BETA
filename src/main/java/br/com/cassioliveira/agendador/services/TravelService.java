package br.com.cassioliveira.agendador.services;

import br.com.cassioliveira.agendador.repository.GlobalQueries;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;

/**
 *
 * @author elisangela
 */
public class TravelService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    private GlobalQueries globalQueries;

    public List<String> returnCities(int ufCode) {
        System.out.println("SERVICE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + globalQueries.returnCities(ufCode));
        return globalQueries.returnCities(ufCode);
    }
}
