/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author fabricio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        //Escrever
        String nome = "Fabricio";
        String login = "Admin";
        String versao = "1.5.1";
        
        String conteudo = nome + ";" + login + ";" + versao;
        
        //Ler
        String c1 = conteudo.split(";")[0];
        String c2 = conteudo.split(";")[1];
        String c3 = conteudo.split(";")[2];
        
        System.out.println("Nome: " + c1);
        System.out.println("Login: " + c2);
        System.out.println("Versão: " + c3);        
        
    }
    
}
