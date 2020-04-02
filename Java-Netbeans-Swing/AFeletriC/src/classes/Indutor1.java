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
 
    //Atributos
    private float L, D, Dcon, N, C, P;

    public float getL() {
        return L;
    }

    public void setL(float L) {
        this.L = L;
    }

    public float getD() {
        return D;
    }

    public void setD(float D) {
        this.D = D;
    }

    public float getDcon() {
        return Dcon;
    }

    public void setDcon(float Dcon) {
        this.Dcon = Dcon;
    }

    public float getN() {
        return N;
    }

    public void setN(float N) {
        this.N = N;
    }

    public float getC() {
        return C;
    }

    public void setC(float C) {
        this.C = C;
    }

    public float getP() {
        return P;
    }

    public void setP(float P) {
        this.P = P;
    }
        
    //Métodos
    public float calcula_nespiras(float L, float D, float Dcon){    
        D=D/10;
        Dcon=Dcon/10;
        N=(float) Math.ceil((100*Dcon*L+Math.sqrt(Math.pow(10,4)*Math.pow(Dcon,2)*Math.pow(L,2)+180*Math.pow(D,3)*L))/(2*Math.pow(D,2)));
        return N;
    }
    
    public float calcula_comprimento(float Dcon, float N){
        C=Dcon*N;
        return C;
    }    
    
    public float calcula_precisao(float D, float C){
        P=D/C;
        return P;
    }                        
    
}
