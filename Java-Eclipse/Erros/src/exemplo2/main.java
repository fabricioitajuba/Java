/*
 * Tratamento de multiplos erros usando Try Catch
 * Eng. Fabricio de Lima Ribeiro
 * 26/02/2019
 */
package exemplo2;

public class main {

	public static void main(String[] args) {

		int[] numeros = {4, 8, 16, 32, 64, 128};
		int[] demon = {2, 0, 4, 8, 0};

		for(int i=0; i<numeros.length; i++){
			try{
				System.out.println(numeros[i] + "/" + demon[i] + " = " + (numeros[i]/demon[i]));
			}
			catch(ArithmeticException e){
				//Sera executado caso ocorra o erro "ArithmeticException"
				System.out.println("Divisao por zero");
			}
			catch(ArrayIndexOutOfBoundsException e){
				//Sera executado caso ocorra o erro "ArrayIndexOutOfBoundsException"
				System.out.println("Nao existe o índice.");
			}			
		}

	}

}
