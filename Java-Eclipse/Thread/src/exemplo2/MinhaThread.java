/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo2;

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
    
        try {
            for(int i=0; i<6; i++){
                System.out.println(nome + " contador " + i);            
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
                e.printStackTrace();            
	}
    }
}
