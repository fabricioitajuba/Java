/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import classes.Pessoa;

/**
 *
 * @author fabricio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pessoa pessoa = new Pessoa();
        
        pessoa.setNome("Fabrício");
        pessoa.setIdade(44);
        pessoa.setCidade("Itajubá");
        imprimeValores(pessoa);
    }
    
    /**
     *
     * @param pessoa
     */
    public static void imprimeValores(Pessoa pessoa){
    
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getIdade());
        System.out.println(pessoa.getCidade());
    }
}
