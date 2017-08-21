package br.com.cassioliveira.sigeris.util.report;

//package br.com.cassioliveira.sigeris.util.report;
//
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Locale;
//import java.util.Map;
//import javax.servlet.http.HttpServletResponse;
//import net.sf.jasperreports.engine.JRExporter;
//import net.sf.jasperreports.engine.JRExporterParameter;
//import net.sf.jasperreports.engine.JRParameter;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.export.JRPdfExporter;
//import net.sf.jasperreports.export.Exporter;
//import net.sf.jasperreports.export.ExporterInput;
//import net.sf.jasperreports.export.OutputStreamExporterOutput;
//import net.sf.jasperreports.export.PdfExporterConfiguration;
//import net.sf.jasperreports.export.PdfReportConfiguration;
//import net.sf.jasperreports.export.SimpleExporterInput;
//import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
//
//public class ReportExecutor {
//
//    private Connection conexao;
//
//    private final String reportPath;
//    private final HttpServletResponse response;
//    private final Map<String, Object> parameters;
//    private final String outputFileName;
//
//    private boolean generatedReport;
//
//    public ReportExecutor(String reportPath,
//            HttpServletResponse response, Map<String, Object> parameters,
//            String outputFileName) {
//        this.reportPath = reportPath;
//        this.response = response;
//        this.parameters = parameters;
//        this.outputFileName = outputFileName;
//
//        this.parameters.put(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));
//    }
//
//    public void geraPdf(String jrxml,
//            Map<String, Object> parametros, OutputStream saida) {
//
//        try {
//
//            // compila jrxml em memoria
//            JasperReport jasper = JasperCompileManager.compileReport(jrxml);
//
//            // preenche relatorio
//            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, this.conexao);
//
//            // exporta para pdf
////            JRPdfExporter exporter = new JRPdfExporter();
////            exporter.setExporterInput(print);
//            JRExporter exporter = new JRPdfExporter();
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);
//
//            exporter.exportReport();
//
//        } catch (Exception e) {
//            throw new RuntimeException("Erro ao gerar relatório", e);
//        }
//    }
//
//    public void execute(Connection connection) throws SQLException {
//        try {
//            InputStream reportStream = this.getClass().getResourceAsStream(this.reportPath);
//
//            JasperPrint print = JasperFillManager.fillReport(reportStream, this.parameters, connection);
//            this.generatedReport = print.getPages().size() > 0;
//
//            if (this.generatedReport) {
//                Exporter<ExporterInput, PdfReportConfiguration, PdfExporterConfiguration, OutputStreamExporterOutput> exporter = new JRPdfExporter();
//                exporter.setExporterInput(new SimpleExporterInput(print));
//                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
//
//                response.setContentType("application/pdf");
//                response.setHeader("Content-Disposition", "attachment; filename=\""
//                        + this.outputFileName + "\"");
//
//                exporter.exportReport();
//            }
//        } catch (Exception e) {
//            throw new SQLException("Erro ao executar relatório " + this.reportPath, e);
//        }
//    }
//
//    public boolean isGeneratedReport() {
//        return generatedReport;
//    }
//
//}
