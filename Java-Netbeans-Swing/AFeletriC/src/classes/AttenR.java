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
    Object[] object;
    
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
        P=(R*(1+V))/(1-V);
        S=(float) ((2*Math.pow(R,2)*P)/(Math.pow(P,2)-Math.pow(R,2)));

        object[0] = P;//R1
        object[1] = S;//R2
        object[2] = P;//R3
        object[3] = 0;
    }
    
    public void Rede_T(int Atten, int R)
    {
        float V, P, S;
        
        V = calcula_tensao(Atten);
        S=(R*(1-V))/(1+V);
        P=(float) ((Math.pow(R,2)-Math.pow(S,2))/(2*S));
        
        object[0] = S;//R1
        object[1] = P;//R2
        object[2] = S;//R3	
        object[3] = 0;
    }
    
    public void Ponte_T(int Atten, int R)
    {
        float V, P, S;
        
        V = calcula_tensao(Atten);
        S=(R*(1-V))/V;
        P=(float) (Math.pow(R,2)/S);
        
        object[0] = S;//R1
        object[1] = R;//R2
        object[2] = R;//R3
        object[3] = P;//R4
    }    
    
}
