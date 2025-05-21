
package rft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginFuncao {

    public static Login validarUsuario(Login l) throws SQLException {
        Conectar conexao = new Conectar();
        conexao.conectar();
        Connection conn = conexao.getConexao(); 

        Login loginValido = null;

        String sql = "SELECT id, login, senha FROM usuario WHERE login = ? AND senha = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, l.getLogin());
            stmt.setString(2, l.getSenha());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    loginValido = new Login();
                    loginValido.setId(rs.getInt("id"));
                    loginValido.setLogin(rs.getString("login"));
                    loginValido.setSenha(rs.getString("senha"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar();
        }

        return loginValido;
    }
    
    public static boolean cadastrar(CadastroAlunos c) {
       
        String sql = "INSERT INTO alunos (id, nome, telefone, cpf, endereco, peso) VALUES (?, ?, ?, ?, ?, ?)";

        
        try {
            Conectar conn = new Conectar();
            conn.conectar();
              
            
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           
            ps.setInt(1, c.getId());
            ps.setString(2, c.getNome());
            ps.setLong(3, c.getTelefone());
            ps.setLong(4, c.getCpf());
            ps.setString(5, c.getEndereco());
            ps.setInt(6, c.getPeso());
            
            
            int atualizacaoTabela = ps.executeUpdate();
            System.out.println("Aluno cadastrado com sucesso");
            conn.desconectar();
            return atualizacaoTabela > 0;
        } catch (SQLException se) {
            System.err.println("erro ao cadastrar aluno: " + se.getMessage());
            return false;
        }
    }  
    
    public static List<CadastroAlunos> listarTodos() {
    List<CadastroAlunos> cads = new ArrayList<>();

    try {
        Conectar conexao = new Conectar();
        conexao.conectar();

        String sql = "SELECT id, nome, telefone, cpf, endereco, peso FROM alunos";
        System.out.println("Executando a consulta SQL...");

        PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            CadastroAlunos ca = new CadastroAlunos();
            ca.setId(rs.getInt("id"));
            ca.setNome(rs.getString("nome"));
            ca.setTelefone(rs.getLong("telefone"));
            ca.setCpf(rs.getLong("cpf"));
            ca.setEndereco(rs.getString("endereco"));
            ca.setPeso(rs.getInt("peso"));

            cads.add(ca);
        }

        System.out.println("Número de alunos encontrados: " + cads.size());

        conexao.desconectar();

    } catch (SQLException se) {
        System.err.println("Erro ao listar alunos: " + se.getMessage());
    }

    return cads;
}
    
    public static List<CadastroAlunos> buscarPorNome(String nome) {
        List<CadastroAlunos> cads = new ArrayList();
        
        try {

            Conectar conexao = new Conectar();
            conexao.conectar();
            
            
            String sql = "SELECT a.*, a.nome as nomeAluno FROM alunos a WHERE a.nome LIKE ?";
            
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                 CadastroAlunos ca = new CadastroAlunos();
                 
                 
            ca.setId(rs.getInt("id"));
            ca.setNome(rs.getString("nome"));
            ca.setTelefone(rs.getLong("telefone"));
            ca.setCpf(rs.getLong("cpf"));
            ca.setEndereco(rs.getString("endereco"));
            ca.setPeso(rs.getInt("peso"));

               cads.add(ca);
            }
            conexao.desconectar();
        }catch(SQLException se) {
            System.err.println("Erro ao filtrar o aluno: " + se);
        }
        return cads;
    }
    
     public static boolean excluir(String id) {
        try {
           
            Conectar conexao = new Conectar();
            conexao.conectar();

            
            String sql = "DELETE FROM alunos WHERE id =?;";
            PreparedStatement cads = conexao.getConexao().prepareStatement(sql);

            
            cads.setString(1, id);

          
            cads.execute();

           
            conexao.desconectar();
            return true;
        } catch (SQLException s) {
            System.out.println("Erro ao deletar registro no banco de dados!" + s);
            return false;
        }
    }
     
     public static List<Pagamentos> listarPagamentos() {
    List<Pagamentos> pags = new ArrayList<>();

    try {
        Conectar conexao = new Conectar();
        conexao.conectar();

        String sql = "SELECT nome, tipoplano, valor, pago FROM pagamentos";
        System.out.println("Executando a consulta SQL...");

        PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Pagamentos pa = new Pagamentos();
            pa.setNome(rs.getString("nome"));
            pa.setTipoplano(rs.getString("tipoplano"));
            pa.setValor(rs.getInt("valor"));
            pa.setPago(rs.getString("pago"));
            
            

            pags.add(pa);
        }

        System.out.println("Número de alunos encontrados: " + pags.size());

        conexao.desconectar();

    } catch (SQLException se) {
        System.err.println("Erro ao listar alunos: " + se.getMessage());
    }

    return pags;
}
     
        public static boolean cadastrarp(Pagamentos p) {
       
        String sql = "INSERT INTO pagamentos (nome, tipoplano, valor, pago) VALUES (?, ?, ?, ?)";

        
        try {
            Conectar conn = new Conectar();
            conn.conectar();
              
            
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           
            ps.setString(1, p.getNome());
            ps.setString(2, p.getTipoplano());
            ps.setInt(3, p.getValor());
            ps.setString(4, p.getPago());
            
            
            
            int atualizacaoTabela = ps.executeUpdate();
            System.out.println("Aluno cadastrado com sucesso");
            conn.desconectar();
            return atualizacaoTabela > 0;
        } catch (SQLException se) {
            System.err.println("erro ao cadastrar aluno: " + se.getMessage());
            return false;
        }
    } 
        
        public static boolean excluirp(String nome) {
        try {
           
            Conectar conexao = new Conectar();
            conexao.conectar();

            
            String sql = "DELETE FROM pagamentos WHERE nome =?;";
            PreparedStatement cads = conexao.getConexao().prepareStatement(sql);

            
            cads.setString(1, nome);

          
            cads.execute();

           
            conexao.desconectar();
            return true;
        } catch (SQLException s) {
            System.out.println("Erro ao deletar registro no banco de dados!" + s);
            return false;
        }
    }
        
         public static List<Pagamentos> buscarPorNomeP(String nome) {
        List<Pagamentos> pags = new ArrayList();
        
        try {

            Conectar conexao = new Conectar();
            conexao.conectar();
            
            String sql = "SELECT p.*, p.nome as nomeAluno FROM pagamentos p WHERE p.nome LIKE ?";
            
            
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                 Pagamentos pa = new Pagamentos();
            
            pa.setNome(rs.getString("nome"));
            pa.setTipoplano(rs.getString("tipoplano"));
            pa.setValor(rs.getInt("valor"));
            pa.setPago(rs.getString("pago"));

               pags.add(pa);
            }
            conexao.desconectar();
        }catch(SQLException se) {
            System.err.println("Erro ao filtrar o aluno: " + se);
        }
        return pags;
    }
         
           public static List<Pre> listarPresenca() {
    List<Pre> p = new ArrayList<>();

    try {
        Conectar conexao = new Conectar();
        conexao.conectar();

        String sql = "SELECT nome, dia, mes, presenca FROM controle_de_presenca";
        System.out.println("Executando a consulta SQL...");

        PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Pre pr = new Pre();
            pr.setNome(rs.getString("nome"));
            pr.setDia(rs.getInt("dia"));
            pr.setMes(rs.getString("mes"));
            pr.setPresenca(rs.getString("presenca"));
            
            

            p.add(pr);
        }

        System.out.println("Número de alunos encontrados: " + p.size());

        conexao.desconectar();

    } catch (SQLException se) {
        System.err.println("Erro ao listar alunos: " + se.getMessage());
    }

    return p;
}
           
            public static boolean cadastrarpr(Pre p) {
       
        String sql = "INSERT INTO controle_de_presenca (nome, dia, mes, presenca) VALUES (?, ?, ?, ?)";

        
        try {
            Conectar conn = new Conectar();
            conn.conectar();
              
            
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           
            ps.setString(1, p.getNome());   
            ps.setInt(2, p.getDia());
            ps.setString(3, p.getMes());
            ps.setString(4, p.getPresenca());
            

            int atualizacaoTabela = ps.executeUpdate();
            System.out.println("Aluno cadastrado com sucesso");
            conn.desconectar();
            return atualizacaoTabela > 0;
        } catch (SQLException se) {
            System.err.println("erro ao cadastrar aluno: " + se.getMessage());
            return false;
        }
    } 
           
           public static List<Pre> buscarPorNomePr(String nome) {
        List<Pre> p = new ArrayList();
        
        try {

            Conectar conexao = new Conectar();
            conexao.conectar();
            
            String sql = "SELECT p.*, p.nome as nomeAluno FROM controle_de_presenca p WHERE p.nome LIKE ?";
            
            
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
            Pre pr = new Pre();
            pr.setNome(rs.getString("nome"));
            pr.setDia(rs.getInt("dia"));
            pr.setMes(rs.getString("mes"));
            pr.setPresenca(rs.getString("presenca"));
            
            

            p.add(pr);
            }
            conexao.desconectar();
        }catch(SQLException se) {
            System.err.println("Erro ao filtrar o aluno: " + se);
        }
        return p;
    }
           
           public static boolean excluirpr(String nome) {
        try {
           
            Conectar conexao = new Conectar();
            conexao.conectar();

            
            String sql = "DELETE FROM controle_de_presenca WHERE nome =?;";
            PreparedStatement p = conexao.getConexao().prepareStatement(sql);

            
            p.setString(1, nome);

          
            p.execute();

           
            conexao.desconectar();
            return true;
        } catch (SQLException s) {
            System.out.println("Erro ao deletar registro no banco de dados!" + s);
            return false;
        }
    }
    
}