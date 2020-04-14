package Controller;

import Exceptions.ErroSistema;
import java.util.List;

public interface CrudDAo<E> {
    
    public void inserir(E entidade) throws ErroSistema;
    public List<E> listar() throws ErroSistema;
    public void alterar(E entidade) throws ErroSistema;
    public void deletar (E entidade) throws ErroSistema;
    
    
}
