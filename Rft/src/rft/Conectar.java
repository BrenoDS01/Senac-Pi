
package rft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conectar {
    
   private Connection conn;

    public Connection getConexao() {
        return conn;
    }
    
    public void conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/fit","root","Bren10flsql@");
            System.out.println("SUCESSO DE CONEXÃO!");
        }catch (ClassNotFoundException cn) {
            System.out.println("Falha ao conectar com o banco " + cn);
        }catch (SQLException sql) {
            System.out.println("Erro de SQL: " + sql);
        }
    }
    
    
    
    public void desconectar(){
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("DESCONECTADO!");
            }
        }catch(SQLException se) {
            System.out.println("Problema ao desconectar do banco: " + se);
        }
    } 
    
   
    
}
