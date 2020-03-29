/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo2;

/**
 *
 * @author fabricio
 */
public class Metodo2 {
 
    public static void main(String[] args) {
        
        //Escrever
        String ArqConfig = "conf.con";
        String nome = "Fabricio";
        String login = "Admin";
        String versao = "1.5.1";
        
        String print = nome + ";" + login + ";" + versao;
        Arquivo.Write(ArqConfig, print);
        
        //Ler
        String conteudo = Arquivo.Read(ArqConfig);
        String c1 = conteudo.split(";")[0];
        String c2 = conteudo.split(";")[1];
        String c3 = conteudo.split(";")[2];
        
        System.out.println("Nome: " + c1);
        System.out.println("Login: " + c2);
        System.out.println("Versão: " + c3);
    }
}
