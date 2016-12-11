//package br.com.cassioliveira.agendador.controllers;
//
//import br.com.cassioliveira.agendador.model.Subject;
//import br.com.cassioliveira.agendador.services.SubjectService;
//import br.com.cassioliveira.agendador.util.jsf.FacesUtil;
//import java.io.Serializable;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.enterprise.inject.Model;
//import javax.inject.Inject;
//import lombok.Getter;
//import lombok.Setter;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
///**
// *
// * @author Cássio Oliveira
// */
//@Model
//public class SubjectBean implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    private static final Log LOGGER = LogFactory.getLog(SubjectBean.class);
//
//    @Inject
//    @Getter
//    @Setter
//    private Subject subject;
//
//    @Inject
//    @Getter
//    @Setter
//    private SubjectService subjectService;
//
//    @Inject
//    @Getter
//    @Setter
//    private Subject selectedSubject;
//
//    private List<Subject> subjects;
//
//    public SubjectBean() {
//    }
//
//    @PostConstruct
//    public void init() {
//        this.subjects = subjectService.findAll();
//    }
//
//    public void save() {
//        this.subjectService.save(subject);
//        if (getEditing()) {
//            FacesUtil.sucessMessage("Cadastro do usuário " + subject.getUser() + " atualizado com sucesso!");
//        } else {
//            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
//        }
//        FacesUtil.redirectTo("SearchSubject.xhtml");
//        subject = new Subject();
//    }
//
//    public void remove() {
//        this.subjectService.delete(selectedSubject);
//        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
//    }
//
//    /*
//     * Metodo que verifica se o objeto esta nulo quando for recuperado.
//     * Se sim, refere-se a um novo cadastro, se não, refere-se a um produto a ser editado
//     */
//    public boolean getEditing() {
//        return this.subject.getId() != null;
//    }
//
//    public List<Subject> getSubjects() {
//        return this.subjects;
//    }
//}
