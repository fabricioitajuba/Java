/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import classe.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author fabricio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Pessoa> listaDePessoas = new ArrayList<>();

        Pessoa bruno = new Pessoa();
        Pessoa jurubeba = new Pessoa();

        bruno.setNome("Bruno Lopes Chagas");
        bruno.setIdade(55);

        jurubeba.setNome("Jurubeba pouco leite");
        jurubeba.setIdade(99);

        listaDePessoas.add(bruno);
        listaDePessoas.add(jurubeba);

        for(int i=0; i<listaDePessoas.size(); i++){
            System.out.println("Nome: " + listaDePessoas.get(i).getNome());   
            System.out.println("Idade: " + listaDePessoas.get(i).getIdade()); 
            System.out.println("\n"); 
        }
    }
    
}
