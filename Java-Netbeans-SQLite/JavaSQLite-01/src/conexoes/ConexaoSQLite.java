/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
}
