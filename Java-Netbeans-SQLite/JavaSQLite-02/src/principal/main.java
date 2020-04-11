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
        System.out.println(teste);
        teste = bancoSQLite.criarTabela("banco.db", "tbl_pessoa");
        System.out.println(teste);
        teste = bancoSQLite.insert("banco.db", 2, "Fabiano", 43);
        System.out.println(teste);
        
    }
    
}
