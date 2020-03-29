package modificador_static;

public class Exer01 {

	static void imprimirValor(){
		System.out.println(Contador.obterValor());
	}
	
	//M�todo principal
	public static void main(String[] args) {		
		imprimirValor();
		Contador.incrementar();
		imprimirValor();
	}
}
