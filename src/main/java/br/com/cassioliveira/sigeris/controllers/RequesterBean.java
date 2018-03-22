package br.com.cassioliveira.sigeris.controllers;

import br.com.cassioliveira.sigeris.enumerations.Gender;
import br.com.cassioliveira.sigeris.enumerations.States;
import br.com.cassioliveira.sigeris.model.Requester;
import br.com.cassioliveira.sigeris.services.RequesterService;
import br.com.cassioliveira.sigeris.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cássio Oliveira
 */
@Model
public class RequesterBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private Requester requester;

    @Inject
    @Getter
    @Setter
    private RequesterService requesterService;

    @Inject
    @Getter
    @Setter
    private Requester selectedRequester;

    private List<Requester> requesters;

    @Getter
    private List<Gender> genders;

    @Getter
    private List<States> states = new ArrayList<>();

    @Getter
    private final List<String> cities = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.genders = Arrays.asList(Gender.values());
        this.states = Arrays.asList(States.values());
        this.requesters = requesterService.findAll();
    }

    public void save() {
        this.requesterService.save(requester);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro do responsável " + requester.getName() + " atualizado com sucesso!");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirectTo("listar-servidores.xhtml");
        requester = new Requester();
    }

    public void remove() {
        this.requesterService.delete(selectedRequester);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
        FacesUtil.redirectTo("listar-solicitantes.xhtml");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.requester.getId() != null;
    }

    /**
     * Método que carrega uma lista de cidades de acordo com o estado
     * selecionado.
     */
    public void returnCities() {
        this.cities.clear();
        if (requester.getUf() != null) {
            for (String filteredCities : requesterService.getCities(requester.getUf().getCode())) {
                this.cities.add(filteredCities);
            }
        }
    }

    public List<Requester> getRequesters() {
        return this.requesters;
    }
}
