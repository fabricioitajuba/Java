/*
 * Aula 33 - Sobrecarga de m�todos e construtores (overload)
 * Isto � a cria��o de v�rios m�todos com o mesmo nome desde 
 * que os tipos de atributos sejam diferetentes;
 * 16/02/19
 */

package sobrecarga;

public class TesteCalculadora {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MinhaCalculadora calc = new MinhaCalculadora();

		calc.soma(1, 2);
		calc.soma(1.0, 2.2);
		calc.soma(5, 4, 2);
		//calc.soma(5);
	}

}
