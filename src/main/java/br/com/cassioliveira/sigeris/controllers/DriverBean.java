package br.com.cassioliveira.sigeris.controllers;

//package br.com.cassioliveira.sigeris.controllers;
//
//import br.com.cassioliveira.sigeris.enumerations.Gender;
//import br.com.cassioliveira.sigeris.enumerations.LicenceCategory;
//import br.com.cassioliveira.sigeris.enumerations.States;
//import br.com.cassioliveira.sigeris.model.Driver;
//import br.com.cassioliveira.sigeris.services.DriverService;
//import br.com.cassioliveira.sigeris.util.jsf.FacesUtil;
//import java.io.Serializable;
//import java.util.ArrayList;
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
//public class DriverBean implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Inject
//    @Getter
//    @Setter
//    private Driver driver;
//
//    @Inject
//    @Getter
//    @Setter
//    private DriverService driverService;
//
//    @Inject
//    @Getter
//    @Setter
//    private Driver selectedDriver;
//
//    @Getter
//    private List<Driver> drivers;
//
//    @Getter
//    private List<Gender> genders;
//
//    @Getter
//    private List<States> states = new ArrayList<>();
//
//    @Getter
//    private final List<String> cities = new ArrayList<>();
//
//    @Getter
//    private List<LicenceCategory> licenceCategories;
//
//    @PostConstruct
//    public void init() {
//        this.genders = Arrays.asList(Gender.values());
//        this.states = Arrays.asList(States.values());
//        this.licenceCategories = Arrays.asList(LicenceCategory.values());
//        this.drivers = driverService.findAll();
//    }
//
//    public void save() {
//        this.driverService.save(driver);
//        if (getEditing()) {
//            FacesUtil.sucessMessage("Cadastro do motorista " + driver.getName() + " atualizado com sucesso!");
//            FacesUtil.redirectTo("listar-motoristas.xhtml");
//        } else {
//            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
//            FacesUtil.redirectTo("cadastro-motorista.xhtml");
//        }
//        driver = new Driver();
//    }
//
//    public void remove() {
//        this.driverService.delete(selectedDriver);
//        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
//    }
//
//    /*
//     * Metodo que verifica se o objeto esta nulo quando for recuperado.
//     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
//     */
//    public boolean getEditing() {
//        return this.driver.getId() != null;
//    }
//
//    /**
//     * Método que carrega uma lista de cidades de acordo com o estado
//     * selecionado.
//     */
//    public void returnCities() {
//        this.cities.clear();
//        if (driver.getUf() != null) {
//            for (String filteredCities : driverService.getCities(driver.getUf().getCode())) {
//                this.cities.add(filteredCities);
//            }
//        }
//    }
//}
