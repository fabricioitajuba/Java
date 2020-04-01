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
public class TrPar {
    
    //Atributos
    private float Fmax, Fmin, CVmax, CVmin, Ct, L;

    public float getFmax() {
        return Fmax;
    }

    public void setFmax(float Fmax) {
        this.Fmax = Fmax;
    }

    public float getFmin() {
        return Fmin;
    }

    public void setFmin(float Fmin) {
        this.Fmin = Fmin;
    }

    public float getCVmax() {
        return CVmax;
    }

    public void setCVmax(float CVmax) {
        this.CVmax = CVmax;
    }

    public float getCVmin() {
        return CVmin;
    }

    public void setCVmin(float CVmin) {
        this.CVmin = CVmin;
    }

    public float getCt() {
        return Ct;
    }

    public void setCt(float Ct) {
        this.Ct = Ct;
    }

    public float getL() {
        return L;
    }

    public void setL(float L) {
        this.L = L;
    }
    
    //Métodos    
    public float calcula_trimmer(float Fmax, float Fmin){
        
        float Rf, Ct;
        
        Rf=Fmax/Fmin;
        Ct=(CVmax-Rf*Rf*CVmin)/(Rf*Rf-1);
        return Ct;
    }
    
    
    public float calcula_indutor(float CVmax, float Fmin, float Ct){
        
        float Cmax, L;

        Cmax=CVmax+Ct;
        Fmin*=1e3;
        Cmax/=1e12;
        L=(float) (1/(4*Math.pow(Math.PI, 2)*Math.pow(Fmin, 2)*Cmax));    
        L*=1e6;
        return L;
    }
    
}
