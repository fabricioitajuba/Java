package teste;

import fatorial.Fatorial;
import fibonacci.Fibonacci;
import somatorio.Somatorio;

public class Teste {

	public static void main(String[] args) {
		
		int fatorialNR = Fatorial.naoRecursivo(5);		
		System.out.println("Fatorial nao recursivo = " + fatorialNR);
		
		int fatorialR = Fatorial.recursivo(5);		
		System.out.println("Fatorial recursivo = " + fatorialR);
				
		System.out.println("Somatorio = " + Somatorio.somatorio(5));
		
		int n = 20;
		System.out.print("Serie de fibonacci de " + n + " ternos = ");
		for(int i = 0; i < n; i++) {
			System.out.print(Fibonacci.fibonacci(i) + " ");
		}
		System.out.println("");
	}

}
