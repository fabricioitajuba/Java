package modificador_static;

public class Contador {

	private static int cont; //private: vari�vel usada somente na classe
							 //static: ser� usada em todas as inst�ncias
	
	public static void incrementar(){
		cont++;
	}
	
	public static void zerar(){
		cont = 0;
	}
	
	public static int obterValor(){
		return cont;
	}
}
