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
public class AttenR {
    
    private int R, Atten;
    private float R1, R2, R3, R4;

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }

    public int getAtten() {
        return Atten;
    }

    public void setAtten(int Atten) {
        this.Atten = Atten;
    }

    public float getR1() {
        return R1;
    }

    public void setR1(float R1) {
        this.R1 = R1;
    }

    public float getR2() {
        return R2;
    }

    public void setR2(float R2) {
        this.R2 = R2;
    }

    public float getR3() {
        return R3;
    }

    public void setR3(float R3) {
        this.R3 = R3;
    }

    public float getR4() {
        return R4;
    }

    public void setR4(float R4) {
        this.R4 = R4;
    }
    
    float calcula_tensao(int Atten)
    {        
        float V;
        
        V=(float) Math.pow(10,(-Atten/20));
        
        return V;
    }

    public void Rede_Pi(int Atten, int R)
    {
        float V, P, S;
        
        V = calcula_tensao(Atten);        
        P=(float) (R*(1+V))/(1-V);
        S=(float) ((2*Math.pow(R,2)*P)/(Math.pow(P,2)-Math.pow(R,2)));

        R1 = P;
        R2 = S;
        R3 = P;
        R4 = 0;
    }
    
    public void Rede_T(int Atten, int R)
    {
        float V, P, S;
        
        V = calcula_tensao(Atten);
        S=(R*(1-V))/(1+V);
        P=(float) ((Math.pow(R,2)-Math.pow(S,2))/(2*S));
        
        R1 = S;//R1
        R2 = P;//R2
        R3 = S;//R3	
        R4 = 0;
    }
    
    public void Ponte_T(int Atten, int R)
    {
        float V, P, S;
        
        V = calcula_tensao(Atten);
        S=(R*(1-V))/V;
        P=(float) (Math.pow(R,2)/S);
        
        R1 = S;//R1
        R2 = R;//R2
        R3 = R;//R3
        R4 = P;//R4
    }    
    
}
