/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import sqlite.BancoSQLite;

/**
 *
 * @author fabricio
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean teste;
        BancoSQLite bancoSQLite = new BancoSQLite();
        
        teste = bancoSQLite.criarBanco("banco.db");
        teste = bancoSQLite.criarTabela("banco.db", "CREATE TABLE IF NOT EXISTS tbl_pessoa (id integer PRIMARY KEY, nome text NOT NULL, idade integer);");

        
    }
    
}
