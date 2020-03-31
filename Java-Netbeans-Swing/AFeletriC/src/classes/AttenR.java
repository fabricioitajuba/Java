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
    
    public int R, Atten;
    public float R1, R2, R3, R4;
    
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
