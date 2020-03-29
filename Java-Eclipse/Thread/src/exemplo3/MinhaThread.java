/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo3;

/**
 *
 * @author fabricio
 */
public class MinhaThread extends Thread{
    
    private String nome;
    private int tempo;
    
    public MinhaThread(String nome, int tempo){

 	this.nome = nome;
        this.tempo = tempo;
        start();//starta a thread maneira mais usada
    }
    
    public void run(){
    
        try {
            for(int i=0; i<10; i++){
                System.out.println(nome + " contador " + i);            
                Thread.sleep(tempo);
            }
        } catch (InterruptedException e) {
                e.printStackTrace();            
	}
        
        System.err.println(nome + " terminou a execusao!");
    }
}