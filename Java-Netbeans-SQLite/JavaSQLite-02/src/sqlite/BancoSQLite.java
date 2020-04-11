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
    public boolean criarTabela(String banco, String sql){

        boolean conectar, criou=false;
        
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
}
