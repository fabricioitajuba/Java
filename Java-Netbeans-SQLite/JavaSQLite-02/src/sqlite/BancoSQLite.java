/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fabricio
 */
public class BancoSQLite {
    
    private Connection conexao;
    
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

        boolean conectar, criou=false;
        String sql = "CREATE TABLE IF NOT EXISTS "+tabela+" (id integer PRIMARY KEY, nome text NOT NULL, idade integer);";
        
        conectar = conectar(banco);
        
        if(conectar == true){
            
            try{
                Statement stmt = criarStatement();
                stmt.execute(sql);
                criou = true;
            }catch(SQLException e){
                //Mensagem de erro na criação da tabela
            }finally{
                desconectar();
            }
        }    
        return criou;
    }
    
    //Insere dados
    public boolean insert(String banco, int id, String nome, int idade){
        
        boolean conectar, inseriu=false;
        
        conectar = conectar(banco);
        
        if(conectar == true){

            String sql = "INSERT INTO tbl_pessoa (id, nome, idade) VALUES(?,?,?);";

             PreparedStatement preparedStatement = criarPreparedStatement(sql);

             try{
                 preparedStatement.setInt(1, id);            
                 preparedStatement.setString(2, nome);
                 preparedStatement.setInt(3, idade);
                 int resultado = preparedStatement.executeUpdate();
                 inseriu = true;
             }catch(SQLException e){
                 //Mensagem de erro na criação da tabela
             }finally{
                 if(preparedStatement != null){
                     try {
                         preparedStatement.close();
                     } catch (SQLException ex) {
                         //
                     }
                 }
                 desconectar();
             }            
        }    
        return inseriu;                
    }
    
    //Atualiza registros
    public boolean update(String banco, String tabela, int id, String nome, int idade){
        
        boolean conectar, alterou=false;
        
        conectar = conectar(banco);
        
        if(conectar == true){

            String sql = "UPDATE "+tabela+" SET nome = ?, idade = ? WHERE id = ?";

             PreparedStatement preparedStatement = criarPreparedStatement(sql);

             try{
                 preparedStatement.setString(1, nome);            
                 preparedStatement.setInt(2, idade);
                 preparedStatement.setInt(3, id);
                 int resultado = preparedStatement.executeUpdate();
                 alterou = true;
             }catch(SQLException e){
                 //Mensagem de erro na criação da tabela
             }finally{
                 if(preparedStatement != null){
                     try {
                         preparedStatement.close();
                     } catch (SQLException ex) {
                         //
                     }
                 }
                 desconectar();
             }            
        }    
        return alterou;                
    }    
    
    //Deleta registros
    public boolean delete(String banco, String tabela, int id){
        
        boolean conectar, alterou=false;
        
        conectar = conectar(banco);
        
        if(conectar == true){

            String sql = "DELETE FROM  "+tabela+" WHERE id = ?";

             PreparedStatement preparedStatement = criarPreparedStatement(sql);

             try{
                 preparedStatement.setInt(1, id);
                 int resultado = preparedStatement.executeUpdate();
                 alterou = true;
             }catch(SQLException e){
                 //Mensagem de erro na criação da tabela
             }finally{
                 if(preparedStatement != null){
                     try {
                         preparedStatement.close();
                     } catch (SQLException ex) {
                         //
                     }
                 }
                 desconectar();
             }            
        }    
        return alterou;                
    }      
    
}
