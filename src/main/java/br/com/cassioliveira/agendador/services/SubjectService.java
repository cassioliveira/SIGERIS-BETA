package br.com.cassioliveira.agendador.services;

import br.com.cassioliveira.agendador.model.Subject;
import br.com.cassioliveira.agendador.repository.Subjects;
import br.com.cassioliveira.agendador.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
public class SubjectService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(SubjectService.class);

    @Inject
    private Subjects subjects;

    @Transactional
    public void save(Subject subject) {
        this.subjects.save(subject);
    }

    @Transactional
    public void delete(Subject subject) {
        subjects.delete(findById(subject.getId()));
    }

    public Subject findById(Long id) {
        return subjects.findById(id);
    }

    public List<Subject> findAll() {
        return subjects.findAll();
    }

    public Subject byUser(String userName) {
        return subjects.byUser(userName);
    }
}
