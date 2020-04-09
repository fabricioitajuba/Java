/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception01;

/**
 *
 * @author fabricio
 */
public class Exception01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    int num, den, res;
    
    num = 4;
    den = 3;
        
    /*try{
        res = num/den;
    }catch(Exception erro){
        System.out.println(erro);
    }finally{
        System.out.println("finally sendo executado!");
    } */       

    try{
        res = num/den;
    }catch(Exception ArithmeticException){
        System.out.println("Divisão por zero!");
    }finally{
        System.out.println("finally sendo executado!");
    }    
    
    }
    
}
