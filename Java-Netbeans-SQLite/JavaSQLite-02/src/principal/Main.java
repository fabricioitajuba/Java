/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Arrays;
import sqlite.BancoSQLite;
import sqlite.TabelaDado;

/**
 *
 * @author fabricio
 */
public class Main {

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
        
        bancoSQLite.setId(1);
        bancoSQLite.setNome("Fabricio");
        bancoSQLite.setIdade(40);
        teste = bancoSQLite.insert("banco.db", "tbl_pessoa");
        System.out.println(teste);

        bancoSQLite.setId(2);
        bancoSQLite.setNome("Angiene");
        bancoSQLite.setIdade(47);        
        teste = bancoSQLite.insert("banco.db", "tbl_pessoa");   
        System.out.println(teste);        
        
        bancoSQLite.setId(3);
        bancoSQLite.setNome("Caio");
        bancoSQLite.setIdade(5);        
        teste = bancoSQLite.insert("banco.db", "tbl_pessoa");        
        System.out.println(teste);

        bancoSQLite.setId(4);
        bancoSQLite.setNome("Fabiano");
        bancoSQLite.setIdade(43);        
        teste = bancoSQLite.insert("banco.db", "tbl_pessoa");        
        System.out.println(teste);        
        
        bancoSQLite.setId(5);
        bancoSQLite.setNome("Fiica");
        bancoSQLite.setIdade(75);        
        teste = bancoSQLite.insert("banco.db", "tbl_pessoa");        
        System.out.println(teste);         

        bancoSQLite.setId(1);
        bancoSQLite.setNome("Fabricio");
        bancoSQLite.setIdade(44);        
        teste = bancoSQLite.update("banco.db", "tbl_pessoa");
        System.out.println(teste);
        
        bancoSQLite.setId(4);
        teste = bancoSQLite.delete("banco.db", "tbl_pessoa");        
        System.out.println(teste);    
        
        bancoSQLite.setId(5);
        teste = bancoSQLite.buscaDado("banco.db", "tbl_pessoa");
        System.out.println("id=" + bancoSQLite.getId() + " nome=" + bancoSQLite.getNome() + " idade=" + bancoSQLite.getIdade());

        
        for(TabelaDado p: bancoSQLite.buscaDados("banco.db", "tbl_pessoa")){

            System.out.println(Arrays.toString(new Object[]{
                p.getId(),
                p.getNome(),
                p.getIdade(),
            }));

        }        

    }
    
}
