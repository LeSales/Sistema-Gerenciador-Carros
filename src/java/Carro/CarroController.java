package Carro;

import Exceptions.ErroSistema;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class CarroController {
    
    private Carro carro = new Carro();
    private List<Carro> listaCarros = new ArrayList<>();
    private CarroDAO carroDAO = new CarroDAO();
    private CarroService carroService = new CarroService();
    
    String modelo;
    
    public void adicionar(){
        try {
            carroDAO.inserir(carro);
            carro = new Carro();
            adicionarMensagem("Salvo!", "Carro salvo com sucesso!!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        carro = new Carro();
    }

//    public void pesquisar(){
//        try {
//            listaCarros = carroService.pesquisaCarro(modelo);
//            if(listaCarros == null || listaCarros.size() == 0){
//                adicionarMensagem("Nenhum dado encontrado!", "Sua lista de carros esta vazia", FacesMessage.SEVERITY_WARN);
//            }
//        } catch (ErroSistema ex) {
//            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
//        }
//    }
    
    public void listar(){
        try {
            listaCarros = carroService.listar();
            if(listaCarros == null || listaCarros.size() == 0){
                adicionarMensagem("Nenhum dado encontrado!", "Sua lista de carros esta vazia", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    public void editar(Carro pCarro){
        carro = pCarro;
    }
    
    public void deletar(Carro carro){
        try {
            carroService.deletar(carro);
            adicionarMensagem("Deletado!", "Carro deletado com sucesso!!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        listar();
        novo();
    }
    
    public void novo(){
        carro = new Carro();
    }
    
    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }
    
    /* ********** Get and Set************* */
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getCarros() {
        return listaCarros;
    }

    public void setCarros(List<Carro> carros) {
        this.listaCarros = carros;
    }

    public List<Carro> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(List<Carro> listaCarros) {
        this.listaCarros = listaCarros;
    }

    public CarroDAO getCarroDAO() {
        return carroDAO;
    }

    public void setCarroDAO(CarroDAO carroDAO) {
        this.carroDAO = carroDAO;
    }

    public CarroService getCarroService() {
        return carroService;
    }

    public void setCarroService(CarroService carroService) {
        this.carroService = carroService;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
}

