/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class ProdutoDAO {
    
    public List<Produto> read(){

        List<Produto> produtos = new ArrayList<>();

        Produto produto = new Produto();        
        
        produto.setId(1);
        produto.setDescricao("Teste1");
        produto.setQtd(10);
        produto.setPreco(10.2);
        produtos.add(produto);
          
        produto.setId(2);
        produto.setDescricao("Teste2");
        produto.setQtd(20);
        produto.setPreco(20.2);
        produtos.add(produto);    
         
        produto.setId(3);
        produto.setDescricao("Teste3");
        produto.setQtd(30);
        produto.setPreco(30.2);
        produtos.add(produto);        

        return produtos;

    }    
}
