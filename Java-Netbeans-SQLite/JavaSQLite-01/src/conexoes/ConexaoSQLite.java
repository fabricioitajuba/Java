/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fabricio
 */
public class ConexaoSQLite {
    
    private Connection conexao;
    
    //Conecta a um banco e cria se não existir
    public boolean conectar(){

        try{
            String url = "jdbc:sqlite:banco/banco.db";
            this.conexao = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.err.println(e.getMessage());

            return false;
        }
        System.out.println("Conectou!!!");
        return true;
    }
    
    //Criar os statements para nossos sqls serem executados
    public boolean desconectar(){

        try{
            if(this.conexao.isClosed() == false){
                this.conexao.close();        
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
            System.out.println("Desconectou!!!");
        return true;
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
}
