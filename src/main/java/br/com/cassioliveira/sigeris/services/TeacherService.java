package br.com.cassioliveira.sigeris.services;

import br.com.cassioliveira.sigeris.model.Discipline;
import br.com.cassioliveira.sigeris.model.Teacher;
import br.com.cassioliveira.sigeris.repository.Disciplines;
import br.com.cassioliveira.sigeris.repository.Teachers;
import br.com.cassioliveira.sigeris.repository.GlobalQueries;
import br.com.cassioliveira.sigeris.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
public class TeacherService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(TeacherService.class);

    @Inject
    private Teachers teachers;
    
//    @Inject
//    private Disciplines disciplines;
//    
//    @Inject
//    @Getter
//    @Setter
//    private Discipline discipline;

    @Inject
    @Getter
    private GlobalQueries globalQueries;

    @Transactional
    public void save(Teacher teacher) {
//        this.disciplines.save(discipline);
        this.teachers.save(teacher);
    }

    @Transactional
    public void delete(Teacher teacher) {
        teachers.delete(findById(teacher.getId()));
    }

    public Teacher findById(Long id) {
        return teachers.findById(id);
    }

    public List<Teacher> findAll() {
        return teachers.findAll();
    }

    public List<String> getCities(int ufCode) {
        return globalQueries.returnCities(ufCode);
    }
    
    public List<String> getTeacherAreas() {
        return teachers.getTeacherAreas();
    }
}
