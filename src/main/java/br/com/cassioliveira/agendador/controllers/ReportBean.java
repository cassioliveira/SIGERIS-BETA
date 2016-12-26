//package br.com.cassioliveira.agendador.controllers;
//
//import br.com.cassioliveira.agendador.util.report.ReportExecutor;
//import javax.enterprise.inject.Model;
//import javax.faces.context.FacesContext;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author cassio
// */
//@Model
//public class ReportBean {
//
//    @Inject
//    private FacesContext facesContext;
//
//    @Inject
//    private HttpServletResponse response;
//
//    @Inject
//    private EntityManager entityManager;
//
//    public void generate() {
//
//        ReportExecutor reportExecutor = new ReportExecutor("/reports/schedulings_ativos.jasper", this.response, null, "Schedulings ativos.pdf");
//
//    }
//
//}
