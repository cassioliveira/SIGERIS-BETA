package br.com.cassioliveira.sigeris.services;

import br.com.cassioliveira.sigeris.model.Discipline;
import br.com.cassioliveira.sigeris.repository.Disciplines;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
public class DisciplineService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(DisciplineService.class);

    @Inject
    private Disciplines disciplines;

    @Transactional
    public void save(Discipline discipline) {
        this.disciplines.save(discipline);
//        if (isDisciplineDuplicated(discipline.getNumber()) && discipline.getId() == null) {
//            throw new BusinessException("Uma sala com esse nome/número já existe");
//        } else {
//        }
    }

    @Transactional
    public void delete(Discipline discipline) {
        disciplines.delete(findById(discipline.getId()));
    }

    public Discipline findById(Long id) {
        return disciplines.findById(id);
    }

    public List<Discipline> findAll() {
        return disciplines.findAll();
    }

    /**
     * Metodo que verifica se a sala que está sendo informada já existe no
     * sistema baseada no nome da mesma, que não pode ser repetida.
     *
     * @param discipline
     * @return
     */
//    public boolean isDisciplineDuplicated(String discipline) {
//        for (String selectedDiscipline : disciplines.getDisciplinesNumber()) {
//            if (selectedDiscipline.equals(discipline)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
