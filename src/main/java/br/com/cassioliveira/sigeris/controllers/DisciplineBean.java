package br.com.cassioliveira.sigeris.controllers;

import br.com.cassioliveira.sigeris.model.Discipline;
import br.com.cassioliveira.sigeris.services.DisciplineService;
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
public class DisciplineBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(DisciplineBean.class);

    @Inject
    @Getter
    @Setter
    private Discipline discipline;

    @Inject
    @Getter
    @Setter
    private DisciplineService disciplineService;

    @Inject
    @Getter
    @Setter
    private Discipline selectedDiscipline;

    @Getter
    @Setter
    private boolean linkedCourseSelection;

    @Getter
    private List<Discipline> allDisciplines;

    @PostConstruct
    public void init() {
        this.allDisciplines = disciplineService.findAll();
    }

    public void save() {
        this.disciplineService.save(discipline);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro da discipline nº " + discipline.getName() + " atualizado com sucesso!");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirectTo("listar-disciplinas.xhtml");
        discipline = new Discipline();
    }

    public void remove() {
        this.disciplineService.delete(selectedDiscipline);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
        FacesUtil.redirectTo("listar-disciplinas.xhtml");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.discipline.getId() != null;
    }
}
