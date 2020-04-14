package Conexao;

import Exceptions.ErroSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/sistema-carros";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "sales";
    
    public static Connection getConexao() throws ErroSistema{
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException ex) {
            throw new ErroSistema("Nao foi possivel conectar ao banco de dados!",ex);                 
        } catch (ClassNotFoundException ex){
            throw new ErroSistema("O driver do banco de dados nao foi encontrado!", ex);
        }
    }
    
    public static void closeConnection(Connection conexao) throws ErroSistema{
        if(conexao!=null){
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new ErroSistema("Erro ao fechar conexao com o banco de dados", ex);
            }
        }
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement ps) throws ErroSistema{
        
        closeConnection(conexao);
        
        try {
            if(ps != null){
            ps.close();
            }
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao fechar conexao com o banco de dados", ex);
        }

    }
    
    public static void closeConnection(Connection conexao, PreparedStatement ps, ResultSet rs) throws ErroSistema{
        
        closeConnection(conexao,ps);
        
        try {
            if(rs != null){
            rs.close();
            }
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao fechar conexao com o banco de dados", ex);
        }

    }
    
}
