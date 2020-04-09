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

    //Comprimento máximo e mínimo ideal do cabo:
    public void comprimento_ideal(float F, float Fator){
        
        float Lreal;
        
        Lreal=(300/(2*F))*Fator;
        Comp_max=0;
		
	while(Comp_max < Lideal)
	{
            Comp_max+=Lreal;
	}
                
        Comp_min=Comp_max-Lreal;
    }
    
}
