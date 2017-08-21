package br.com.cassioliveira.sigeris.controllers;

//package br.com.cassioliveira.sigeris.controllers;
//
//import br.com.cassioliveira.sigeris.enumerations.CarsTypes;
//import br.com.cassioliveira.sigeris.model.Transport;
//import br.com.cassioliveira.sigeris.services.TransportService;
//import br.com.cassioliveira.sigeris.util.jsf.FacesUtil;
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.enterprise.inject.Model;
//import javax.inject.Inject;
//import lombok.Getter;
//import lombok.Setter;
//
///**
// *
// * @author Cássio Oliveira
// */
//@Model
//public class TransportBean implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Inject
//    @Getter
//    @Setter
//    private Transport transport;
//
//    @Inject
//    @Getter
//    @Setter
//    private TransportService transportService;
//
//    @Inject
//    @Getter
//    @Setter
//    private Transport selectedTransport;
//
//    @Getter
//    private List<Transport> transports;
//    
//    @Getter
//    private List<CarsTypes> carsTypes;
//
//    @PostConstruct
//    public void init() {
//        this.carsTypes = Arrays.asList(CarsTypes.values());
//        this.transports = transportService.findAll();
//    }
//
//    public void save() {
//        this.transportService.save(transport);
//        if (getEditing()) {
//            FacesUtil.sucessMessage("Cadastro do " + transport.getBrand() + " atualizado com sucesso!");
//            FacesUtil.redirectTo("listar-veiculos.xhtml");
//        } else {
//            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
//            FacesUtil.redirectTo("cadastro-veiculo.xhtml");
//        }
//        transport = new Transport();
//    }
//
//    public void remove() {
//        this.transportService.delete(selectedTransport);
//        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
//    }
//
//    /*
//     * Metodo que verifica se o objeto esta nulo quando for recuperado.
//     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
//     */
//    public boolean getEditing() {
//        return this.transport.getId() != null;
//    }
//}
