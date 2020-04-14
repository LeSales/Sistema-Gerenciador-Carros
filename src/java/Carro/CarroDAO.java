package Carro;

import Conexao.FabricaConexao;
import Controller.CrudDAo;
import Exceptions.ErroSistema;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarroDAO implements CrudDAo<Carro>{
 
    public void inserir(Carro carro) throws ErroSistema{
        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement ps = null;
        
        try {
            ps = conexao.prepareStatement("INSERT INTO carro (modelo,fabricante,cor,ano) VALUES(?,?,?,?)");
            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getFabricante());
            ps.setString(3, carro.getCor());
            ps.setDate(4, new Date(carro.getAno().getTime()));
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar o carro!", ex);
        } finally {
            FabricaConexao.closeConnection(conexao, ps);
        }
    }
    
    public List<Carro> listar() throws ErroSistema{
        
        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Carro> listaCarros = new ArrayList<>();
        
        try {
            ps = conexao.prepareStatement("SELECT * FROM carro");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Carro carro = new Carro();
                
                carro.setSeqCarro(rs.getInt("seq_carro"));
                carro.setFabricante(rs.getString("fabricante"));
                carro.setModelo(rs.getString("modelo"));
                carro.setCor(rs.getString("cor"));
                carro.setAno(rs.getDate("ano"));
                listaCarros.add(carro);
            }
            
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar buscar os carros", ex);
        } finally{
            FabricaConexao.closeConnection(conexao, ps, rs);
        }
        
        return listaCarros;
        
    }
    
     public void alterar(Carro carro) throws ErroSistema{
        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement ps = null;
        
        try {
            ps = conexao.prepareStatement("UPDATE carro SET modelo=?,fabricante=?,cor=?,ano=? WHERE seq_carro=?");
            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getFabricante());
            ps.setString(3, carro.getCor());
            ps.setDate(4, new Date(carro.getAno().getTime()));
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar o carro!", ex);
        } finally {
            FabricaConexao.closeConnection(conexao, ps);
        }
    }

    public void deletar(Carro carro) throws ErroSistema{
        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement ps = null;

        try {
            ps = conexao.prepareStatement("DELETE FROM carro WHERE seq_carro=?");
            ps.setInt(1, carro.getSeqCarro());

            ps.execute();
        } catch (SQLException ex) {
    
            throw new ErroSistema("Erro ao deletar o carro!", ex);
   }
}

//    public List<Carro> pesquisar(String pModelo) throws ErroSistema{
//        
//        Connection conexao = FabricaConexao.getConexao();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        List<Carro> listaCarros = new ArrayList<>();
//        String sql = "SELECT * FROM carro where upper(modelo) like '%"+pModelo.toUpperCase() + "%'";
//            System.out.println(sql);
//
//        try {
//            ps = conexao.prepareStatement(sql);
//            rs = ps.executeQuery();
//            
//            
//            while(rs.next()){
//                Carro carro = new Carro();
//                
//                carro.setSeqCarro(rs.getInt("seq_carro"));
//                carro.setFabricante(rs.getString("fabricante"));
//                carro.setModelo(rs.getString("modelo"));
//                carro.setCor(rs.getString("cor"));
//                carro.setAno(rs.getDate("ano"));
//                listaCarros.add(carro);
//            }
//            
//        } catch (SQLException ex) {
//            throw new ErroSistema("Erro ao tentar buscar os carros", ex);
//        } finally{
//            FabricaConexao.closeConnection(conexao, ps, rs);
//        }
//        
//        return listaCarros;
//        
//    }
    
    
}
