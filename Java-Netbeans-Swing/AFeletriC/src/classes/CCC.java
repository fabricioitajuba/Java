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
public class CCC {

    //Atributos
    private float F, Lideal, Fator, Comp_max, Comp_min;

    public float getComp_max() {
        return Comp_max;
    }

    public void setComp_max(float Comp_max) {
        this.Comp_max = Comp_max;
    }

    public float getComp_min() {
        return Comp_min;
    }

    public void setComp_min(float Comp_min) {
        this.Comp_min = Comp_min;
    }

    public float getFator() {
        return Fator;
    }

    public void setFator(float Fator) {
        this.Fator = Fator;
    }

    public float getF() {
        return F;
    }

    public void setF(float F) {
        this.F = F;
    }

    public float getLideal() {
        return Lideal;
    }

    public void setLideal(float Lideal) {
        this.Lideal = Lideal;
    }

    //Comprimento máximo ideal do cabo:
    public float comprimento_maximo_ideal(float F, float Fator){
        
        float Lreal, Laux;
        
        Lreal=(300/(2*F))*Fator;
	Laux=Lreal;
		
	while(Lreal < Lideal)
	{
            Lreal+=Laux;
	}
                
        return Lreal;
    }
    
    //Comprimento mínimo ideal do cabo:
    public float comprimento_minimo_ideal(float Lreal){
        
        float Laux;
        
        Laux=Lreal;
	while(Lreal < Lideal)
	{
            Lreal+=Laux;
	}        
        Lreal-=Laux;
        
        return Lreal;
    }
}
