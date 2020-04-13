package principal;

import classe.Produto;
import classe.ProdutoDAO;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabricio
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProdutoDAO pdao = new ProdutoDAO();

        for(Produto p: pdao.read()){
            System.out.println(Arrays.toString(new Object[]{p.getId(), p.getDescricao(), p.getQtd(), p.getPreco()}));
        }                

    }    
}
