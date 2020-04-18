/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.Arrays;
import mysql.BancoMySQL;

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
        
        BancoMySQL bancoMySQL = new BancoMySQL();
        
        teste = bancoMySQL.fazerLogin("senhas", "fabricio", "1234");
        System.out.println(teste);
        
        teste = bancoMySQL.fazerLogin("senhas", "fabiano", "4321");
        System.out.println(teste);        
        
        bancoMySQL.setId(1);
        bancoMySQL.setNome("Fabricio");
        bancoMySQL.setIdade(20);
        teste = bancoMySQL.Insert("pessoas");
        System.out.println(teste);
        
        bancoMySQL.setId(2);
        bancoMySQL.setNome("Fabiano");
        bancoMySQL.setIdade(43);
        teste = bancoMySQL.Insert("pessoas");        
        System.out.println(teste);        
        
        bancoMySQL.setId(3);
        bancoMySQL.setNome("Angiene");
        bancoMySQL.setIdade(47);
        teste = bancoMySQL.Insert("pessoas");        
        System.out.println(teste);                
        
        bancoMySQL.setId(2);
        teste = bancoMySQL.Delete("pessoas");        
        System.out.println(teste);             
        
        bancoMySQL.setId(2);
        bancoMySQL.setNome("Caio");
        bancoMySQL.setIdade(5);
        teste = bancoMySQL.Insert("pessoas");        
        System.out.println(teste);             
        
        bancoMySQL.setId(1);
        bancoMySQL.setNome("Fabricio");
        bancoMySQL.setIdade(44);        
        teste = bancoMySQL.update("pessoas");
        System.out.println(teste);        
        
        ////Busca registro
        bancoMySQL.setId(2);
        teste = bancoMySQL.buscaDado("pessoas");
        System.out.println(teste);        
        System.out.println("id=" + bancoMySQL.getId() + " nome=" + bancoMySQL.getNome() + " idade=" + bancoMySQL.getIdade());       
        
        //Busca registros
        ArrayList<BancoMySQL> bancoMySQLs = new ArrayList<>();                //#
        
        for(BancoMySQL p: bancoMySQL.buscaDados("pessoas")){

            System.out.println(Arrays.toString(new Object[]{
                p.getId(),
                p.getNome(),
                p.getIdade(),
            }));
            
            bancoMySQLs.add(p);
        }        
        
        System.out.println("\n");                                            //#
        for(int i=0; i<bancoMySQLs.size(); i++){                              //#
            System.out.println("Id: " + bancoMySQLs.get(i).getId());          //#   
            System.out.println("Nome: " + bancoMySQLs.get(i).getNome());      //#   
            System.out.println("Idade: " + bancoMySQLs.get(i).getIdade());    //# 
            System.out.println("\n");                                        //#
        }                
        
    }
    
}
