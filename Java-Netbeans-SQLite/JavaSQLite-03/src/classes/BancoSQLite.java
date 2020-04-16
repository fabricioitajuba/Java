/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author fabricio
 */
public class BancoSQLite {
    
    private int Id, Idade;
    private String Nome;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        this.Idade = idade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }
        
    private Connection conexao;
    
    //DadosTabela dadosTabela = new DadosTabela();
    
    //Conecta a um banco e cria se não existir
    public boolean conectar(String banco){

        try{
            String url = "jdbc:sqlite:banco/"+banco;
            this.conexao = DriverManager.getConnection(url);
            return true;
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    //Criar os statements para nossos sqls serem executados
    public void desconectar(){

        try{
            if(this.conexao.isClosed() == false){
                this.conexao.close();        
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    //Criar banco de dados
    public boolean criarBanco(String banco){
    
        boolean conectou;
        
        conectou = conectar(banco);
        
        if (conectou == true){
            desconectar();
            return true;
        }else{
            return false;
        }                
    }
    
    public Statement criarStatement(){
    
        try{
            return this.conexao.createStatement();
        }catch(SQLException e){
            return null;
        }
    }
    
    public PreparedStatement criarPreparedStatement(String sql){
    
        try{
            return this.conexao.prepareStatement(sql);
        }catch(SQLException e){
            return null;
        }
    }    
    
    public Connection getConexao(){
        return this.conexao;
    }    
    
    //Cria tabela
    public boolean criarTabela(String banco, String tabela){

        boolean conectar, ok=false;
        String sql = "CREATE TABLE IF NOT EXISTS "+tabela+" (id integer PRIMARY KEY, nome text NOT NULL, idade integer);";
        
        conectar = conectar(banco);
        
        if(conectar == true){
            
            try{
                Statement stmt = criarStatement();
                stmt.execute(sql);
                ok = true;
            }catch(SQLException e){
                //Mensagem de erro na criação da tabela
            }finally{
                desconectar();
            }
        }    
        return ok;
    }
    
    //Insere dados
    public boolean insert(String banco, String tabela){
        
        boolean conectar, ok=false;
        
        conectar = conectar(banco);
        
        if(conectar == true){

            String sql = "INSERT INTO "+tabela+" (nome, idade) VALUES(?,?);";

             PreparedStatement preparedStatement = criarPreparedStatement(sql);

             try{          
                 preparedStatement.setString(1, Nome);
                 preparedStatement.setInt(2, Idade);
                 int resultado = preparedStatement.executeUpdate();
                 ok = true;
             }catch(SQLException e){
                 //Mensagem de erro na criação da tabela
                 JOptionPane.showMessageDialog(null, "Erro: "+e);
             }finally{
                 if(preparedStatement != null){
                     try {
                         preparedStatement.close();
                     } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro: "+ex);
                     }
                 }
                 desconectar();
             }            
        }    
        return ok;                
    }
    
    //Atualiza registros
    public boolean update(String banco, String tabela){
        
        boolean conectar, ok=false;
        
        conectar = conectar(banco);
        
        if(conectar == true){

            String sql = "UPDATE "+tabela+" SET nome = ?, idade = ? WHERE id = ?";

             PreparedStatement preparedStatement = criarPreparedStatement(sql);

             try{
                 preparedStatement.setString(1, Nome);            
                 preparedStatement.setInt(2, Idade);
                 preparedStatement.setInt(3, Id);
                 int resultado = preparedStatement.executeUpdate();
                 ok = true;
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "Erro: "+e);
             }finally{
                 if(preparedStatement != null){
                     try {
                         preparedStatement.close();
                     } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro: "+ex);
                     }
                 }
                 desconectar();
             }            
        }    
        return ok;                
    }    
    
    //Deleta registros
    public boolean delete(String banco, String tabela){
        
        boolean conectar, ok=false;
        
        conectar = conectar(banco);
        
        if(conectar == true){

            String sql = "DELETE FROM  "+tabela+" WHERE id = ?";

             PreparedStatement preparedStatement = criarPreparedStatement(sql);

             try{
                 preparedStatement.setInt(1, Id);
                 int resultado = preparedStatement.executeUpdate();
                 ok = true;
             }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro: "+e);
             }finally{
                 if(preparedStatement != null){
                     try {
                         preparedStatement.close();
                     } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro: "+ex);
                     }
                 }
                 desconectar();
             }            
        }    
        return ok;                
    }      
    
    //Busca registro
    public boolean buscaDado(String banco, String tabela){
        
        boolean conectar, ok=false;
        
        conectar = conectar(banco);
        
        if(conectar == true){

            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;

            String query = "SELECT * FROM "+tabela+" WHERE id = ?;";

            try{
                preparedStatement = criarPreparedStatement(query);
                preparedStatement.setInt(1,Id);

                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    Id = resultSet.getInt("id");
                    Nome = resultSet.getString("nome");
                    Idade = resultSet.getInt("idade");
                }
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro: "+e);
                ok=false;
            }finally{
                try{
                    resultSet.close();
                    preparedStatement.close();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro: "+ex);
                    //ex.printStackTrace();
                    ok=false;
                }
                desconectar();                
            }                       
        }    
        return ok;                
    }        
 
    //Busca registros e salva em uma lista
    public List<BancoSQLite> buscaNomes(String banco, String tabela){
        
        boolean conectar;
        
        List<BancoSQLite> tabelas = new ArrayList<>();
        
        conectar = conectar(banco);
        
        if(conectar == true){

            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;

            //String query = "SELECT * FROM "+tabela+" WHERE nome=?;";
            String query = "SELECT * FROM "+tabela+" WHERE nome LIKE ?;";

            try{
                preparedStatement = criarPreparedStatement(query);
                preparedStatement.setString(1, "%"+Nome+"%");   
                resultSet = preparedStatement.executeQuery();
                
                while(resultSet.next()){
                    
                    BancoSQLite bancoSQLite = new BancoSQLite();    
                    
                    bancoSQLite.setId(resultSet.getInt("id"));
                    bancoSQLite.setNome(resultSet.getString("nome"));
                    bancoSQLite.setIdade(resultSet.getInt("idade"));
                    
                    tabelas.add(bancoSQLite);
                }
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro: "+e);
            }finally{
                try{
                    resultSet.close();
                    preparedStatement.close();           
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro: "+ex);
                }
                desconectar();
            }                                              
        }    
        return tabelas;
    }        
    
    //Busca registros e salva em uma lista
    public List<BancoSQLite> buscaDados(String banco, String tabela){
        
        boolean conectar, ok=false;
        
        List<BancoSQLite> tabelas = new ArrayList<>();
        
        conectar = conectar(banco);
        
        if(conectar == true){

            ResultSet resultSet = null;
            Statement statement = null;

            String query = "SELECT * FROM "+tabela;

            statement = criarStatement();

            try{
                resultSet = statement.executeQuery(query);

                while(resultSet.next()){
                    
                    BancoSQLite bancoSQLite = new BancoSQLite();    
                    
                    bancoSQLite.setId(resultSet.getInt("id"));
                    bancoSQLite.setNome(resultSet.getString("nome"));
                    bancoSQLite.setIdade(resultSet.getInt("idade"));
                    
                    tabelas.add(bancoSQLite);
                }
                //ok=true;
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro: "+e);
            }finally{
                try{
                    resultSet.close();
                    statement.close();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro: "+ex);
                }
                desconectar();
            }                                              
        }    
        //return ok;  
        return tabelas;
    }         
    
    //Faz login
    public boolean fazerLogin(String banco, String tabela, String Login, String Senha){
        
        boolean conectar, ok=false;
        
        conectar = conectar(banco);
        
        if(conectar == true){

            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;

            String query = "SELECT * FROM "+tabela+" WHERE login = ? and senha = ?;";

            try{
                preparedStatement = criarPreparedStatement(query);
                preparedStatement.setString(1,Login);
                preparedStatement.setString(2,Senha);

                resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    ok=true;
                }
                
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro: "+e);
            }finally{
                try{
                    resultSet.close();
                    preparedStatement.close();
                }catch(SQLException ex){
                    //ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro: "+ex);
                    System.out.println(ex);
                }
                desconectar();
            }                       
        }    
        return ok;                
    }     
    
}
