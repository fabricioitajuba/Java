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
        teste = bancoSQLite.insert("banco.db", 1, "Fabricio", 40);
        System.out.println(teste);
        teste = bancoSQLite.insert("banco.db", 2, "Angiene", 47);   
        System.out.println(teste);        
        teste = bancoSQLite.insert("banco.db", 3, "Caio", 5);        
        System.out.println(teste);
        teste = bancoSQLite.insert("banco.db", 4, "Fabiano", 43);        
        System.out.println(teste);        
        teste = bancoSQLite.update("banco.db", "tbl_pessoa", 1, "Fabricio", 44);
        System.out.println(teste);
        teste = bancoSQLite.delete("banco.db", "tbl_pessoa", 4);
        System.out.println(teste);        
    }
    
}
