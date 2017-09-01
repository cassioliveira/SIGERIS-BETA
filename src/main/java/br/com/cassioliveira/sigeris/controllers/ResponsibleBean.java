package br.com.cassioliveira.sigeris.controllers;

import br.com.cassioliveira.sigeris.enumerations.Gender;
import br.com.cassioliveira.sigeris.enumerations.States;
import br.com.cassioliveira.sigeris.model.Responsible;
import br.com.cassioliveira.sigeris.services.ResponsibleService;
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
public class ResponsibleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private Responsible responsible;

    @Inject
    @Getter
    @Setter
    private ResponsibleService responsibleService;

    @Inject
    @Getter
    @Setter
    private Responsible selectedResponsible;

    private List<Responsible> responsibles;

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
        this.responsibles = responsibleService.findAll();
    }

    public void save() {
        this.responsibleService.save(responsible);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro do responsável " + responsible.getName() + " atualizado com sucesso!");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirectTo("listar-responsaveis.xhtml");
        responsible = new Responsible();
    }

    public void remove() {
        this.responsibleService.delete(selectedResponsible);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
        FacesUtil.redirectTo("listar-responsaveis.xhtml");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.responsible.getId() != null;
    }

    /**
     * Método que carrega uma lista de cidades de acordo com o estado
     * selecionado.
     */
    public void returnCities() {
        this.cities.clear();
        if (responsible.getUf()!= null) {
            for (String filteredCities : responsibleService.getCities(responsible.getUf().getCode())) {
                this.cities.add(filteredCities);
            }
        }
    }

    public List<Responsible> getResponsibles() {
        return this.responsibles;
    }
}
