/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo1;

/**
 *
 * @author fabricio
 */
public class MinhaThread extends Thread{
    
    private String nome;
    
    public MinhaThread(String nome){

 	this.nome = nome;
        start();//starta a thread maneira mais usada
    }
    
    public void run(){
    
        System.out.println("Executando a thread!");
    }

}
