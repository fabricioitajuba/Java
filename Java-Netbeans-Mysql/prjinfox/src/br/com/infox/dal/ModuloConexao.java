/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.dal;

import java.sql.*;

/**
 *
 * @author fabricio
 */
public class ModuloConexao {
    //Método responsável por estabelecer a conexao com o banco
    public static Connection conector(){
        java.sql.Connection conexao = null;
        //a linha abaixo "chama" o driver
        String driver = "com.mysql.jdbc.Driver";
        //armazenando informações referente ao banco
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "";
        //Estabelecendo a conexao com o banco
        try {
            //caso dê certo
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //caso dê errado
            //System.out.println(e); //mostra o erro
            return null;
        }
    }
}
