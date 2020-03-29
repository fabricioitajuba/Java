package fatorial;

public class Fatorial {

	//Fatorial nao recursivo
	public static int naoRecursivo(int num) {
		
		if(num == 0) {
			return 1;
		}
		
		int total = 1;
		for(int i = num; i > 1; i--) {
			total *= i;
		}
		return total;
	}
	
	//Fatorial recursivo
	public static int recursivo(int num) {
		
		if(num == 0){
			return 1;
		}
		
		return num * recursivo(num - 1);
	}
	
}
