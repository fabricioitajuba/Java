/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author fabricio
 */
public class Indutor1 {
 
    public float L, D, Dcon, n, l, p;
	
    public float diametro_indutor(float D){
        D=D/10;
        return D;
    }
    
    public float diametro_condutor(float Dcon){
        Dcon=Dcon/10;
        return Dcon;
    }

    public float calcula_nespiras(float L, float D, float Dcon){               
        n=(float) Math.ceil((100*Dcon*L+Math.sqrt(Math.pow(10,4)*Math.pow(Dcon,2)*Math.pow(L,2)+180*Math.pow(D,3)*L))/(2*Math.pow(D,2)));
        return n;
    }
    
    public float calcula_comprimento(float Dcon, float n){
        l=Dcon*n;
        return l*10;
    }    
    
    public float calcula_precisao(float D, float l){
        p=D/l;
        return p*10;
    }                        
    
}
