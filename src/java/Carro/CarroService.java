
package Carro;

import Exceptions.ErroSistema;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarroService {
    
//    public List<Carro> pesquisaCarro(String pModelo) throws ErroSistema{
//        CarroDAO carroDAO = new CarroDAO();
//        
//        List<Carro> listaCarro = new ArrayList<>();
//        listaCarro =  carroDAO.pesquisar(pModelo);
//
//       
//        return listaCarro;
//        
//    }
//    
    public List<Carro> listar() throws ErroSistema{
        CarroDAO carroDAO = new CarroDAO();
        
        List<Carro> listaCarro = new ArrayList<>();
        listaCarro =  carroDAO.listar();

       
        return listaCarro;
        
    }
    
    
    public void salvar(Carro carro) throws ErroSistema{
        CarroDAO carroDAO = new CarroDAO();
        if (carro.getSeqCarro()== 0){
            try {
                carroDAO.inserir(carro);
            } catch (ErroSistema ex) {
                throw new ErroSistema("Erro ao tentar inserir o carro!", ex);
            }
        } else {
            try {
                carroDAO.alterar(carro);
            } catch (ErroSistema ex) {
                throw new ErroSistema("Erro ao tentar salvar o carro!", ex);
            }
        }
        
    }
    
    
    public void deletar(Carro carro) throws ErroSistema{
        CarroDAO carroDAO = new CarroDAO();
        try {
            carroDAO.deletar(carro);
        } catch (ErroSistema ex) {
            throw new ErroSistema("Erro ao deletar o carro!", ex);
        }
    }
}
